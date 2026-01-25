@echo off
echo ========================================
echo   MO DASHBOARD JMETER DE CHUP ANH
echo ========================================
echo.

echo [1] Mo Dashboard Thread Group 1...
start results\html_dashboard_group1\index.html
timeout /t 2 /nobreak >nul

echo [2] Mo Dashboard Thread Group 2...
start results\html_dashboard_group2\index.html
timeout /t 2 /nobreak >nul

echo [3] Mo Dashboard Thread Group 3...
start results\html_dashboard_group3\index.html

echo.
echo ========================================
echo   DA MO 3 DASHBOARD!
echo ========================================
echo.
echo CHUP ANH NHU SAU:
echo.
echo [Group 1] Dashboard + Statistics
echo [Group 2] Dashboard + Statistics
echo [Group 3] Dashboard + Statistics
echo.
pause
