from rest_framework import serializers
from .models import Bairro, Distrito, Provincia


class Bairro_Serializer(serializers.ModelSerializer):
    nome_distrito = serializers.CharField(
        source='district.district_name', read_only=True)

    class Meta:
        model = Bairro
        fields = ['id', 'district', 'nome_distrito', 'bairro_name']

        extra_kwargs = {
            "district": {
                "write_only": True
            }
        }


class Provincia_Serializer(serializers.ModelSerializer):
    zone = serializers.CharField(source='zone.zone_name')

    class Meta:
        model = Provincia
        fields = ['id', 'province_name', 'acronym', 'zone']


class Distrito_Serializer(serializers.ModelSerializer):
    province_name = serializers.CharField(
        source='province.province_name', read_only=True)

    class Meta:
        model = Distrito
        fields = ['id', 'province_name', 'province', 'district_name']

        extra_kwargs = {
            "province": {
                "write_only": True
            }
        }
