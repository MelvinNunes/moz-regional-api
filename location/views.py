from functools import partial
from django.shortcuts import get_object_or_404, render
from rest_framework.views import APIView
from rest_framework import permissions
from rest_framework.response import Response
from .models import Provincia, Bairro, Distrito
from .serializers import Provincia_Serializer, Bairro_Serializer, Distrito_Serializer
# Create your views here.


# Provincia

class Provincia_View(APIView):
    permission_classes = [permissions.AllowAny]

    def get(self, request,  *args, **kwargs):
        id = kwargs.get('id')
        if id is not None:
            obj = get_object_or_404(Provincia, id=id)
            data = Provincia_Serializer(obj, many=False).data
            response = {
                'success': True,
                'status_code': 200,
                'message': f'Provincia com o id {id}.',
                'data': data,
            }
            return Response(response, status=200)
        queryset = Provincia.objects.all()
        data = Provincia_Serializer(queryset, many=True).data
        response = {
            'success': True,
            'status_code': 200,
            'message': 'Provincias de Moçambique.',
            'data': data,
        }
        return Response(response, status=200)

class Provincia_Name_View(APIView):
    permission_classes = [permissions.AllowAny]

    def get(self, request,  *args, **kwargs):
        provinceName = kwargs.get('nomeProvincia')
        if provinceName is not None:
            queryset = Provincia.objects.filter(province_name__contains=provinceName)
            data = Provincia_Serializer(queryset, many=True).data
            response = {
                'success': True,
                'status_code': 200,
                'message': f'Provincias de Moçambique com o nome: {provinceName}.',
                'data': data,
            }
            return Response(response, status=200)
        response = {
                'success': False,
                'status_code': 400,
                'message': f'Por favor insira um nome da provincia.',
            }
        return Response(response, status=400)
    
class Provincia_Zone_View(APIView):
    permission_classes = [permissions.AllowAny]

    def get(self, request,  *args, **kwargs):
        zoneId = kwargs.get('zone')
        if zoneId is not None:
            queryset = Provincia.objects.filter(zone=zoneId)
            data = Provincia_Serializer(queryset, many=True).data
            response = {
                'success': True,
                'status_code': 200,
                'message': f'Provincias de Moçambique da zona: {zoneId}.',
                'data': data,
            }
            return Response(response, status=200)
        response = {
                'success': False,
                'status_code': 400,
                'message': f'Por favor insira uma zona do pais.',
            }
        return Response(response, status=400)

class Provincia_Admin_View(APIView):
    permission_classes = [permissions.IsAuthenticated]

    def post(self, request,  *args, **kwargs):
        serializer = Provincia_Serializer(data=request.data)
        if serializer.is_valid(raise_exception=True):
            acronym = serializer.validated_data.get('acronym')
            new_acron = acronym.upper()
            serializer.save(createdBy=request.user, acronym=new_acron)
            response = {
                'success': True,
                'status_code': 201,
                'message': 'Provincia criada com sucesso.',
                'data': serializer.data,
            }
            return Response(response, status=201)

    def get(self, request,  *args, **kwargs):
        id = kwargs.get('id')
        if id is not None:
            obj = get_object_or_404(Provincia, id=id)
            data = Provincia_Serializer(obj, many=False).data
            response = {
                'success': True,
                'status_code': 200,
                'message': f'Provincia com o id {id}.',
                'data': data,
            }
            return Response(response, status=200)
        queryset = Provincia.objects.all()
        data = Provincia_Serializer(queryset, many=True).data
        response = {
            'success': True,
            'status_code': 200,
            'message': 'Provincias de Moçambique.',
            'data': data,
        }
        return Response(response, status=200)

    def put(self, request,  *args, **kwargs):
        id = request.data.get("id")
        if id is not None:
            obj = get_object_or_404(Provincia, id=id)
        else:
            response = {
                'success': True,
                'status_code': 404,
                'message': 'Nenhum id foi inserido.',
            }
            return Response(response, status=404)
        serializer = Provincia_Serializer(
            obj, data=request.data, many=False, partial=True)
        if serializer.is_valid(raise_exception=True):
            serializer.save(updatedBy=request.user)
            response = {
                'success': True,
                'status_code': 200,
                'message': 'Provincia criada com sucesso.',
            }
            return Response(response, status=200)

    def delete(self, request,  *args, **kwargs):
        id = kwargs.get('id')
        if id is not None:
            obj = get_object_or_404(Provincia, id=id)
            obj.soft_delete()
            response = {
                'success': True,
                'status_code': 200,
                'message': 'Provincia apagada com sucesso.',
            }
            return Response(response, status=200)
        response = {
            'success': True,
            'status_code': 404,
            'message': 'Provincia não encontrada.',
        }
        return Response(response, status=404)

# Distrito


class Distrito_View(APIView):
    permission_classes = [permissions.AllowAny]

    def get(self, request,  *args, **kwargs):
        id = kwargs.get('id')
        if id is not None:
            obj = get_object_or_404(Distrito, id=id)
            data = Distrito_Serializer(obj, many=False).data
            response = {
                'success': True,
                'status_code': 200,
                'message': f'Distrito com o id {id}.',
                'data': data,
            }
            return Response(response, status=200)
        queryset = Distrito.objects.all()
        data = Distrito_Serializer(queryset, many=True).data
        response = {
            'success': True,
            'status_code': 200,
            'message': 'Distritos de Moçambique.',
            'data': data,
        }
        return Response(response, 200)

class Distrito_From_Province_View(APIView):
    permission_classes = [permissions.AllowAny]

    def get(self, request,  *args, **kwargs):
        provinceId = kwargs.get('province')
        if provinceId is not None:
            queryset = Distrito.objects.filter(province=provinceId)
            data = Distrito_Serializer(queryset, many=True).data
            response = {
                'success': True,
                'status_code': 200,
                'message': f'Distritos da provincia com o ID: {provinceId}.',
                'data': data,
            }
            return Response(response, status=200)
        response = {
            'success': False,
            'status_code': 400,
            'message': 'Por favor insira o ID da provincia.',
            'data': data,
        }
        return Response(response, 400)

class Distrito_Admin_View(APIView):
    permission_classes = [permissions.IsAuthenticated]

    def post(self, request,  *args, **kwargs):
        serializer = Distrito_Serializer(data=request.data)
        if serializer.is_valid(raise_exception=True):
            serializer.save(createdBy=request.user)
            response = {
                'success': True,
                'status_code': 201,
                'message': 'Distrito adicionado com sucesso.',
                'data': serializer.data,
            }
            return Response(response, 201)

    def get(self, request,  *args, **kwargs):
        id = kwargs.get('id')
        if id is not None:
            obj = get_object_or_404(Distrito, id=id)
            data = Distrito_Serializer(obj, many=False).data
            response = {
                'success': True,
                'status_code': 200,
                'message': f'Distrito com o id {id}.',
                'data': data,
            }
            return Response(response, status=200)
        queryset = Distrito.objects.all()
        data = Distrito_Serializer(queryset, many=True).data
        response = {
            'success': True,
            'status_code': 200,
            'message': 'Distritos de Moçambique.',
            'data': data,
        }
        return Response(response, 200)

    def put(self, request,  *args, **kwargs):
        id = request.data.get("id")
        if id is not None:
            obj = get_object_or_404(Distrito, id=id)
        else:
            return Response(response={
                'success': True,
                'status_code': 404,
                'message': 'Nenhum id foi encontrado.',
            }, status=404)
        serializer = Distrito_Serializer(
            obj, data=request.data, many=False, partial=True)
        if serializer.is_valid(raise_exception=True):
            serializer.save(updatedBy=request.user)
            response = {
                'success': True,
                'status_code': 200,
                'message': 'Distrito atualizado com sucesso.',
                'data': serializer.data,
            }
            return Response(response, status=200)

    def delete(self, request,  *args, **kwargs):
        id = request.data.get("id")
        if id is not None:
            obj = get_object_or_404(Distrito, id=id)
            obj.soft_delete()
            response = {
                'success': True,
                'status_code': 200,
                'message': 'Distrito apagado com sucesso.',
            }
            return Response(response, status=200)
        response = {
            'success': True,
            'status_code': 404,
            'message': 'Distrito não encontrado.',
        }
        return Response(response, status=404)

# Bairro


class Bairro_View(APIView):
    permission_classes = [permissions.AllowAny]

    def get(self, request,  *args, **kwargs):
        id = kwargs.get('id')
        if id is not None:
            obj = get_object_or_404(Bairro, id=id)
            data = Bairro_Serializer(obj, many=False).data
            response = {
                'success': True,
                'status_code': 200,
                'message': f'Bairro com id {id}.',
                'data': data,
            }
            return Response(response, status=200)
        queryset = Bairro.objects.all()
        data = Bairro_Serializer(queryset, many=True).data
        response = {
            'success': True,
            'status_code': 200,
            'message': 'Bairros de Moçambique.',
            'data': data,
        }
        return Response(response, status=200)


class Bairro_Admin_View(APIView):
    permission_classes = [permissions.IsAuthenticated]

    def post(self, request,  *args, **kwargs):
        serializer = Bairro_Serializer(data=request.data)
        if serializer.is_valid(raise_exception=True):
            serializer.save(createdBy=request.user)
            response = {
                'success': True,
                'status_code': 201,
                'message': 'Bairro criado com sucesso.',
                'data': serializer.data,
            }
            return Response(response, status=201)

    def get(self, request,  *args, **kwargs):
        id = kwargs.get('id')
        if id is not None:
            obj = get_object_or_404(Bairro, id=id)
            data = Bairro_Serializer(obj, many=False).data
            response = {
                'success': True,
                'status_code': 200,
                'message': f'Bairro com id {id}.',
                'data': data,
            }
            return Response(response, status=200)
        queryset = Bairro.objects.all()
        data = Bairro_Serializer(queryset, many=True).data
        response = {
            'success': True,
            'status_code': 200,
            'message': 'Bairros de Moçambique.',
            'data': data,
        }
        return Response(response, status=200)

    def put(self, request,  *args, **kwargs):
        id = request.data.get("id")
        if id is not None:
            obj = get_object_or_404(Bairro, id=id)
        else:
            response = {
                'success': False,
                'status_code': 404,
                'message': 'Nenhum id foi indicado.',
            }
            return Response(response, status=404)
        serializer = Bairro_Serializer(obj, data=request.data, many=False)
        if serializer.is_valid(raise_exception=True):
            serializer.update(
                instance=obj, validated_data=serializer.validated_data)
            response = {
                'success': True,
                'status_code': 200,
                'message': 'Bairro atualizado com sucesso.',
            }
            return Response(response, status=200)

    def delete(self, request,  *args, **kwargs):
        id = request.data.get("id")
        if id is not None:
            obj = get_object_or_404(Bairro, id=id)
            obj.soft_delete()
            response = {
                'success': True,
                'status_code': 200,
                'message': 'Bairro apagado com sucesso.',
            }
            return Response(response, status=200)
        response = {
            'success': False,
            'status_code': 404,
            'message': 'Bairro não encontrado.',
        }
        return Response(response, status=404)
