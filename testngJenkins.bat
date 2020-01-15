set projectLocation=C:\Users\rasto\eclipse-workspace\Facebook_New\com\automation\facebook
cd %projectLocation%
set classpath=%projectLocation%\bin;%projectLocation%\lib\*
java org.testng.TestNG %projectLocation%\testng.xml
pause