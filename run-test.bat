@echo off
echo ====================================
echo   CHAY JUNIT TEST
echo ====================================
echo.

REM Download JUnit neu chua co
if not exist "lib" mkdir lib
if not exist "lib\junit-platform-console-standalone-1.9.3.jar" (
    echo [1] Download JUnit...
    curl -L -o "lib\junit-platform-console-standalone-1.9.3.jar" "https://repo1.maven.org/maven2/org/junit/platform/junit-platform-console-standalone/1.9.3/junit-platform-console-standalone-1.9.3.jar"
    echo.
)

REM Compile code
echo [2] Compile code...
if exist "bin" rmdir /s /q bin
mkdir bin
javac -encoding UTF-8 -d bin -cp "lib\*" src\StudentAnalyzer.java
javac -encoding UTF-8 -d bin -cp "lib\*;bin" test\StudentAnalyzerTest.java
echo.

REM Chay test
echo [3] Chay test...
echo ====================================
java -jar lib\junit-platform-console-standalone-1.9.3.jar -cp bin --scan-classpath
echo ====================================
echo.

if %ERRORLEVEL% EQU 0 (
    echo [OK] TAT CA TEST PASS!
) else (
    echo [LOI] CO TEST THAT BAI!
)
echo.
pause

