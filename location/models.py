from django.db import models
from django.conf import settings
from datetime import datetime

class PaisZona(models.Model):
    zone_name = models.CharField(max_length=255, unique=True, null=False)
    createdBy = models.ForeignKey(
        settings.AUTH_USER_MODEL, on_delete=models.CASCADE, null=True, related_name='ZoneCreatedBy')
    created_at = models.DateTimeField(auto_now_add=True)
    updated_at = models.DateTimeField(auto_now=True)
    updated_by = models.ForeignKey(
        settings.AUTH_USER_MODEL, on_delete=models.CASCADE, null=True, related_name='ZoneUpdatedBy')


class Provincia(models.Model):
    province_name = models.CharField(
        max_length=255, unique=True, null=False)
    zone = models.ForeignKey(PaisZona, on_delete=models.CASCADE, )
    acronym = models.CharField(max_length=3, unique=True)
    createdBy = models.ForeignKey(
        settings.AUTH_USER_MODEL, on_delete=models.CASCADE, null=True, related_name='ProvinciaCreatedBy')
    created_at = models.DateTimeField(auto_now_add=True)
    updated_at = models.DateTimeField(auto_now=True)
    updated_by = models.ForeignKey(
        settings.AUTH_USER_MODEL, on_delete=models.CASCADE, null=True, related_name='ProvinciaUpdatedBy')


class Distrito(models.Model):
    province = models.ForeignKey(
        Provincia, on_delete=models.CASCADE)
    district_name = models.CharField(
        max_length=255, unique=True, null=False)
    createdBy = models.ForeignKey(
        settings.AUTH_USER_MODEL, on_delete=models.CASCADE, null=True, related_name='DistritoCreatedBy')
    created_at = models.DateTimeField(auto_now_add=True)
    updated_at = models.DateTimeField(auto_now=True)
    updated_by = models.ForeignKey(
        settings.AUTH_USER_MODEL, on_delete=models.CASCADE, null=True, related_name='DistritoUpdatedBy')


class Bairro(models.Model):
    bairro_name = models.CharField(max_length=255, unique=True, null=False)
    district = models.ForeignKey(
        Distrito, on_delete=models.CASCADE)
    createdBy = models.ForeignKey(
        settings.AUTH_USER_MODEL, on_delete=models.CASCADE, null=True,  related_name='BairroCreatedBy')
    created_at = models.DateTimeField(auto_now_add=True)
    updated_at = models.DateTimeField(auto_now=True)
    updated_by = models.ForeignKey(
        settings.AUTH_USER_MODEL, on_delete=models.CASCADE, null=True, related_name='BairroUpdatedBy')
