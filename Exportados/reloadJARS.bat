@echo off
pause
cd SERVER001
DEL /Q *.*
cd "D:\WORKSPACE\WORKSPACE_JAVA\JAVA_AVANZADO\220724 - Curso de Java Avanzado Spring Framework\220724_java_avanzado_spring_framework\WORKSPACE_VS_CODE\s012configserver"
start /b /wait cmd /c "mvnw.cmd clean package -DskipTests"
color 0a
cd target
xcopy *.jar "D:\WORKSPACE\WORKSPACE_JAVA\JAVA_AVANZADO\220724 - Curso de Java Avanzado Spring Framework\220724_java_avanzado_spring_framework\Exportados\SERVER001\"



cd "D:\WORKSPACE\WORKSPACE_JAVA\JAVA_AVANZADO\220724 - Curso de Java Avanzado Spring Framework\220724_java_avanzado_spring_framework\WORKSPACE_VS_CODE\s014eurekaservice"
start /b /wait cmd /c "mvnw.cmd clean package -DskipTests"
cd target
xcopy *.jar "D:\WORKSPACE\WORKSPACE_JAVA\JAVA_AVANZADO\220724 - Curso de Java Avanzado Spring Framework\220724_java_avanzado_spring_framework\Exportados\SERVER001\"
color 0b




cd "D:\WORKSPACE\WORKSPACE_JAVA\JAVA_AVANZADO\220724 - Curso de Java Avanzado Spring Framework\220724_java_avanzado_spring_framework\WORKSPACE_VS_CODE\s015admindashboard"
start /b /wait cmd /c "mvnw.cmd clean package -DskipTests"
cd target
xcopy *.jar "D:\WORKSPACE\WORKSPACE_JAVA\JAVA_AVANZADO\220724 - Curso de Java Avanzado Spring Framework\220724_java_avanzado_spring_framework\Exportados\SERVER001\"
color 0c



cd "D:\WORKSPACE\WORKSPACE_JAVA\JAVA_AVANZADO\220724 - Curso de Java Avanzado Spring Framework\220724_java_avanzado_spring_framework\WORKSPACE_VS_CODE\s013parametrosfestivos"
start /b /wait cmd /c "mvnw.cmd clean package -DskipTests"
cd target
xcopy *.jar "D:\WORKSPACE\WORKSPACE_JAVA\JAVA_AVANZADO\220724 - Curso de Java Avanzado Spring Framework\220724_java_avanzado_spring_framework\Exportados\SERVER001\"
color 0d


cd "D:\WORKSPACE\WORKSPACE_JAVA\JAVA_AVANZADO\220724 - Curso de Java Avanzado Spring Framework\220724_java_avanzado_spring_framework\WORKSPACE_VS_CODE\s011productos"
start /b /wait cmd /c "mvnw.cmd clean package -DskipTests"
cd target
xcopy *.jar "D:\WORKSPACE\WORKSPACE_JAVA\JAVA_AVANZADO\220724 - Curso de Java Avanzado Spring Framework\220724_java_avanzado_spring_framework\Exportados\SERVER001\"
color 0d




cd "D:\WORKSPACE\WORKSPACE_JAVA\JAVA_AVANZADO\220724 - Curso de Java Avanzado Spring Framework\220724_java_avanzado_spring_framework\WORKSPACE_VS_CODE\s016gateway"
start /b /wait cmd /c "mvnw.cmd clean package -DskipTests"
cd target
xcopy *.jar "D:\WORKSPACE\WORKSPACE_JAVA\JAVA_AVANZADO\220724 - Curso de Java Avanzado Spring Framework\220724_java_avanzado_spring_framework\Exportados\SERVER001\"
color 0e




echo   _____ _____ ____  __  __ ___ _   _  ___   
echo  |_   _| ____|  _ \|  \/  |_ _| \ | |/ _ \  
echo    | | |  _| | |_) | |\/| || ||  \| | | | | 
echo    | | | |___|  _ <| |  | || || |\  | |_| | 
echo    |_| |_____|_| \_\_|  |_|___|_| \_|\___/  
echo                                             



pause