from django.urls import path
from .views import Bairro_View, Distrito_View, Distrito_From_Province_View, Provincia_View, Provincia_Zone_View, Provincia_Name_View, Provincia_Admin_View, Bairro_Admin_View, Distrito_Admin_View


urlpatterns = [
    path('provincias', Provincia_View.as_view()),
    path('provincias/<int:id>', Provincia_View.as_view()),
    path('provincias/s/<str:nomeProvincia>', Provincia_Name_View.as_view()),
    path('provincias/zona/<int:zone>', Provincia_Zone_View.as_view()),
    path('distritos', Distrito_View.as_view()),
    path('distritos/<int:id>', Distrito_View.as_view()),
    path('distritos/p/<int:province>', Distrito_From_Province_View.as_view()),
    path('bairros', Bairro_View.as_view()),
    path('bairros/<int:id>', Bairro_View.as_view()),
    
    # path('admin/bairro', Bairro_Admin_View.as_view()),
    # path('admin/bairro/<int:id>', Bairro_Admin_View.as_view()),
    # path('admin/provincia', Provincia_Admin_View.as_view()),
    # path('admin/provincia/<int:id>', Provincia_Admin_View.as_view()),
    # path('admin/distrito', Distrito_Admin_View.as_view()),
]
