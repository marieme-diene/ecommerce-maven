@echo off
echo Exportation du projet E-Commerce Maven...
echo.

REM Création du ZIP sur le bureau
powershell -Command "Compress-Archive -Path 'C:\Users\PC\OneDrive\Documents\MIGL_JAVA\ecommerce-maven' -DestinationPath 'C:\Users\PC\Desktop\ecommerce-maven-complete.zip' -Force"

echo.
echo Projet exporté avec succès sur le bureau !
echo Nom du fichier: ecommerce-maven-complete.zip
echo.
pause
