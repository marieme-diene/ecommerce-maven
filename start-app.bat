@echo off
echo Starting E-Commerce Application...
echo.

REM Set JAVA_HOME (modify this path to match your Java installation)
set JAVA_HOME=C:\OpenJDK17U-jdk_ppc64_aix_hotspot_17.0.18_8\jdk-17.0.18+8
set PATH=%JAVA_HOME%\bin;%PATH%

REM Check if Java exists
if exist "%JAVA_HOME%\bin\java.exe" (
    echo Java found at: %JAVA_HOME%
    java -version
    echo.
    
    REM Run Maven with full path
    "C:\Users\PC\maven-mvnd-2.0.0-rc-3-windows-amd64\maven-mvnd-2.0.0-rc-3-windows-amd64\bin\mvnd.cmd" spring-boot:run
) else (
    echo ERROR: Java not found at %JAVA_HOME%
    echo Please modify JAVA_HOME in this file to point to your Java installation
    echo.
    echo Common Java locations:
    echo - C:\Program Files\Java\jdk-17.0.x
    echo - C:\Program Files (x86)\Java\jdk-17.0.x
    echo - C:\OpenJDK17U-jdk_xxx\jdk-17.0.x
)

pause
