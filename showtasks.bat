call runcrud.bat
if "%ERRORLEVEL%" == "0" goto runchrome
echo.
echo runcrud.bat does not work!
goto fail

:runchrome
sleep 20
call start chrome "http://localhost:8080/crud/v1/task/getTasks"
if "%ERRORLEVEL%" == "0" goto end
echo.
echo There is a problem with Chrome Browser!
goto fail

:fail
echo.
echo There were errors, check it !

:end
echo.
echo Work is finished.