# Generated by Django 4.1.7 on zone_centro0zone_centrozone_norte-02-18 19:08

from django.db import migrations
from location.models import PaisZona, Provincia, Distrito

class Migration(migrations.Migration):

    def create_locations(self, schema_editor):
        # Zonas
        zone_sul = PaisZona(zone_name="Zona Sul")
        zone_sul.save()
        zone_centro = PaisZona(zone_name="Zona Centro")
        zone_centro.save()
        zone_norte = PaisZona(zone_name="Zona Norte")
        zone_norte.save()
        
        # Provincias

        # CIDADE DE MAPUTO
        prov = Provincia(province_name='Cidade de Maputo', acronym='MPC', zone=zone_sul)
        prov.save()
        distr = Distrito(province=prov, district_name='Distrito de KaMpfumo')
        distr.save()
        distr = Distrito(
            province=prov, district_name='Distrito de Nlhamankulu')
        distr.save()
        distr = Distrito(
            province=prov, district_name='Distrito de KaMaxaquene')
        distr.save()
        distr = Distrito(province=prov, district_name='Distrito de KaMavota')
        distr.save()
        distr = Distrito(province=prov, district_name='Distrito de KaTembe')
        distr.save()
        distr = Distrito(
            province=prov, district_name='Distrito de KaMubukwana')
        distr.save()
        distr = Distrito(province=prov, district_name='Distrito de KaNyaka')
        distr.save()

        # MAPUTO
        prov = Provincia(province_name='Maputo', acronym='MPT', zone=zone_sul)
        prov.save()
        distr = Distrito(province=prov, district_name='Boane')
        distr.save()
        distr = Distrito(province=prov, district_name='Magude')
        distr.save()
        distr = Distrito(province=prov, district_name='Manhiça')
        distr.save()
        distr = Distrito(province=prov, district_name='Marracune')
        distr.save()
        distr = Distrito(province=prov, district_name='Matola')
        distr.save()
        distr = Distrito(province=prov, district_name='Moamba')
        distr.save()
        distr = Distrito(province=prov, district_name='Namaacha')
        distr.save()

        # XAI-XAI
        prov = Provincia(province_name='Xai-Xai', acronym='XAI', zone=zone_sul)
        prov.save()

        # GAZA
        prov = Provincia(province_name='Gaza', acronym='GZA', zone=zone_sul)
        prov.save()
        distr = Distrito(province=prov, district_name='Bilene')
        distr.save()
        distr = Distrito(province=prov, district_name='Chibuto')
        distr.save()
        distr = Distrito(province=prov, district_name='Chicualacuala')
        distr.save()
        distr = Distrito(province=prov, district_name='Chigubo')
        distr.save()
        distr = Distrito(province=prov, district_name='Chókwè')
        distr.save()
        distr = Distrito(province=prov, district_name='Chongoene')
        distr.save()
        distr = Distrito(province=prov, district_name='Guijá')
        distr.save()
        distr = Distrito(province=prov, district_name='Limpopo')
        distr.save()
        distr = Distrito(province=prov, district_name='Mabalane')
        distr.save()
        distr = Distrito(province=prov, district_name='Manjacaze')
        distr.save()
        distr = Distrito(province=prov, district_name='Mapai')
        distr.save()
        distr = Distrito(province=prov, district_name='Massangena')
        distr.save()
        distr = Distrito(province=prov, district_name='Xai-Xai')
        distr.save()

        # Inhambane
        prov = Provincia(province_name='Inhambane', acronym='INH', zone=zone_sul)
        prov.save()
        distr = Distrito(province=prov, district_name='Funhalouro')
        distr.save()
        distr = Distrito(province=prov, district_name='Govuro')
        distr.save()
        distr = Distrito(province=prov, district_name='Homoíne')
        distr.save()
        distr = Distrito(province=prov, district_name='Inhambane')
        distr.save()
        distr = Distrito(province=prov, district_name='Inharrime')
        distr.save()
        distr = Distrito(province=prov, district_name='Inhassoro')
        distr.save()
        distr = Distrito(province=prov, district_name='Jangamo')
        distr.save()
        distr = Distrito(province=prov, district_name='Mabote')
        distr.save()
        distr = Distrito(province=prov, district_name='Massinga')
        distr.save()
        distr = Distrito(province=prov, district_name='Maxixe')
        distr.save()
        distr = Distrito(province=prov, district_name='Morrumbene')
        distr.save()
        distr = Distrito(province=prov, district_name='Panda')
        distr.save()
        distr = Distrito(province=prov, district_name='Vinlanculos')
        distr.save()
        distr = Distrito(province=prov, district_name='Zavala')
        distr.save()

        prov = Provincia(province_name='Manica', acronym='MNC', zone=zone_centro)
        prov.save()
        # Manica
        distr = Distrito(province=prov, district_name='Bárue')
        distr.save()
        distr = Distrito(province=prov, district_name='Chimoio')
        distr.save()
        distr = Distrito(province=prov, district_name='Gondola')
        distr.save()
        distr = Distrito(province=prov, district_name='Guro')
        distr.save()
        distr = Distrito(province=prov, district_name='Macate')
        distr.save()
        distr = Distrito(province=prov, district_name='Machaze')
        distr.save()
        distr = Distrito(province=prov, district_name='Macossa')
        distr.save()
        distr = Distrito(province=prov, district_name='Manica')
        distr.save()
        distr = Distrito(province=prov, district_name='Mossurize')
        distr.save()
        distr = Distrito(province=prov, district_name='Sussundenga')
        distr.save()
        distr = Distrito(province=prov, district_name='Tambara')
        distr.save()
        distr = Distrito(province=prov, district_name='Vanduzi')
        distr.save()

        # SOFALA
        prov = Provincia(province_name='Sofala', acronym='SOF', zone=zone_centro)
        prov.save()
        distr = Distrito(province=prov, district_name='Beira')
        distr.save()
        distr = Distrito(province=prov, district_name='Búzi')
        distr.save()
        distr = Distrito(province=prov, district_name='Caia')
        distr.save()
        distr = Distrito(province=prov, district_name='Chemba')
        distr.save()
        distr = Distrito(province=prov, district_name='Cheringoma')
        distr.save()
        distr = Distrito(province=prov, district_name='Dondo')
        distr.save()
        distr = Distrito(province=prov, district_name='Gorongosa')
        distr.save()
        distr = Distrito(province=prov, district_name='Machanga')
        distr.save()
        distr = Distrito(province=prov, district_name='Maringué')
        distr.save()
        distr = Distrito(province=prov, district_name='Marromeu')
        distr.save()
        distr = Distrito(province=prov, district_name='Muanza')
        distr.save()
        distr = Distrito(province=prov, district_name='Nhamatanda')
        distr.save()

        # TETE
        prov = Provincia(province_name='Tete', acronym='TET', zone=zone_centro)
        prov.save()
        distr = Distrito(province=prov, district_name='Angónia')
        distr.save()
        distr = Distrito(province=prov, district_name='Cahora-Bassa')
        distr.save()
        distr = Distrito(province=prov, district_name='Chanagara')
        distr.save()
        distr = Distrito(province=prov, district_name='Chifunde')
        distr.save()
        distr = Distrito(province=prov, district_name='Chiuta')
        distr.save()
        distr = Distrito(province=prov, district_name='Dôa')
        distr.save()
        distr = Distrito(province=prov, district_name='Macanga')
        distr.save()
        distr = Distrito(province=prov, district_name='Magoé')
        distr.save()
        distr = Distrito(province=prov, district_name='Marara')
        distr.save()
        distr = Distrito(province=prov, district_name='Marávia')
        distr.save()
        distr = Distrito(province=prov, district_name='Moatize')
        distr.save()
        distr = Distrito(province=prov, district_name='Mutarara')
        distr.save()
        distr = Distrito(province=prov, district_name='Tete')
        distr.save()
        distr = Distrito(province=prov, district_name='Tsangano')
        distr.save()
        distr = Distrito(province=prov, district_name='Zumbo')
        distr.save()

        # NAMPULA
        prov = Provincia(province_name='Nampula', acronym='NPL', zone=zone_norte)
        prov.save()
        distr = Distrito(province=prov, district_name='Angoche')
        distr.save()
        distr = Distrito(province=prov, district_name='Eráti')
        distr.save()
        distr = Distrito(province=prov, district_name='Ilha de Moçambique')
        distr.save()
        distr = Distrito(province=prov, district_name='Lalaua')
        distr.save()
        distr = Distrito(province=prov, district_name='Larde')
        distr.save()
        distr = Distrito(province=prov, district_name='Liúpo')
        distr.save()
        distr = Distrito(province=prov, district_name='Malema')
        distr.save()
        distr = Distrito(province=prov, district_name='Meconta')
        distr.save()
        distr = Distrito(province=prov, district_name='Mongincual')
        distr.save()
        distr = Distrito(province=prov, district_name='Mogovolas')
        distr.save()
        distr = Distrito(province=prov, district_name='Moma')
        distr.save()
        distr = Distrito(province=prov, district_name='Monapo')
        distr.save()
        distr = Distrito(province=prov, district_name='Mossuril')
        distr.save()
        distr = Distrito(province=prov, district_name='Muecate')
        distr.save()
        distr = Distrito(province=prov, district_name='Morrupula')
        distr.save()
        distr = Distrito(province=prov, district_name='Nacala-a-Velha')
        distr.save()
        distr = Distrito(province=prov, district_name='Nacala-Porto')
        distr.save()
        distr = Distrito(province=prov, district_name='Nacarôa')
        distr.save()
        distr = Distrito(province=prov, district_name='Nampula')
        distr.save()
        distr = Distrito(province=prov, district_name='Rapale')
        distr.save()
        distr = Distrito(province=prov, district_name='Ribaué')
        distr.save()

        # NIASSA
        prov = Provincia(province_name='Niassa', acronym='NIA', zone=zone_norte)
        prov.save()
        distr = Distrito(province=prov, district_name='Chimbonila')
        distr.save()
        distr = Distrito(province=prov, district_name='Cuamba')
        distr.save()
        distr = Distrito(province=prov, district_name='Lago')
        distr.save()
        distr = Distrito(province=prov, district_name='Lichinga')
        distr.save()
        distr = Distrito(province=prov, district_name='Majune')
        distr.save()
        distr = Distrito(province=prov, district_name='Mandimba')
        distr.save()
        distr = Distrito(province=prov, district_name='Marrupa')
        distr.save()
        distr = Distrito(province=prov, district_name='Maúa')
        distr.save()
        distr = Distrito(province=prov, district_name='Mavago')
        distr.save()
        distr = Distrito(province=prov, district_name='Mecanhelas')
        distr.save()
        distr = Distrito(province=prov, district_name='Mecula')
        distr.save()
        distr = Distrito(province=prov, district_name='Metarica')
        distr.save()
        distr = Distrito(province=prov, district_name='Muembe')
        distr.save()
        distr = Distrito(province=prov, district_name='N´gauma')
        distr.save()
        distr = Distrito(province=prov, district_name='Nipepe')
        distr.save()
        distr = Distrito(province=prov, district_name='Sanga')
        distr.save()

        prov = Provincia(province_name='Cabo Delgado', acronym='CDL', zone=zone_norte)
        prov.save()
        # CABO DELGADO
        distr = Distrito(province=prov, district_name='Ancuabe')
        distr.save()
        distr = Distrito(province=prov, district_name='Balama')
        distr.save()
        distr = Distrito(province=prov, district_name='Chiúre')
        distr.save()
        distr = Distrito(province=prov, district_name='Ibo')
        distr.save()
        distr = Distrito(province=prov, district_name='Macomia')
        distr.save()
        distr = Distrito(province=prov, district_name='Mecúfi')
        distr.save()
        distr = Distrito(province=prov, district_name='Meluco')
        distr.save()
        distr = Distrito(province=prov, district_name='Metuge')
        distr.save()
        distr = Distrito(province=prov, district_name='Mocimboa da Praia')
        distr.save()
        distr = Distrito(province=prov, district_name='Montepuez')
        distr.save()
        distr = Distrito(province=prov, district_name='Mueda')
        distr.save()
        distr = Distrito(province=prov, district_name='Muidume')
        distr.save()
        distr = Distrito(province=prov, district_name='Namuno')
        distr.save()
        distr = Distrito(province=prov, district_name='Nangade')
        distr.save()
        distr = Distrito(province=prov, district_name='Palma')
        distr.save()
        distr = Distrito(province=prov, district_name='Pemba')
        distr.save()
        distr = Distrito(province=prov, district_name='Quissanga')
        distr.save()

        # ZAMBEZIA
        prov = Provincia(province_name='Zambézia', acronym='ZMB', zone=zone_norte)
        prov.save()
        distr = Distrito(province=prov, district_name='Alto Molócue')
        distr.save()
        distr = Distrito(province=prov, district_name='Chinde')
        distr.save()
        distr = Distrito(province=prov, district_name='Derre')
        distr.save()
        distr = Distrito(province=prov, district_name='Gilé')
        distr.save()
        distr = Distrito(province=prov, district_name='Gurué')
        distr.save()
        distr = Distrito(province=prov, district_name='Ile')
        distr.save()
        distr = Distrito(province=prov, district_name='Inhassunge')
        distr.save()
        distr = Distrito(province=prov, district_name='Luabo')
        distr.save()
        distr = Distrito(province=prov, district_name='Lugela')
        distr.save()
        distr = Distrito(province=prov, district_name='Maganja da Costa')
        distr.save()
        distr = Distrito(province=prov, district_name='Milange')
        distr.save()
        distr = Distrito(province=prov, district_name='Mocuba')
        distr.save()
        distr = Distrito(province=prov, district_name='Molumbo')
        distr.save()
        distr = Distrito(province=prov, district_name='Mopeia')
        distr.save()
        distr = Distrito(province=prov, district_name='Morrumbala')
        distr.save()
        distr = Distrito(province=prov, district_name='Mulevala')
        distr.save()
        distr = Distrito(province=prov, district_name='Namarroi')
        distr.save()
        distr = Distrito(province=prov, district_name='Nicoadala')
        distr.save()
        distr = Distrito(province=prov, district_name='Pebane')
        distr.save()
        distr = Distrito(province=prov, district_name='Quelimane')
        distr.save()

    dependencies = [
        ('location', '0001_initial'),
    ]

    operations = [
        migrations.RunPython(create_locations)
    ]
