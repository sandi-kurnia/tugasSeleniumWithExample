*** Settings ***
Library           Selenium2Library

*** Variables ***
${F_Name}         Anton
${L_Name}         yolo
${URL_Register}    https://demowebshop.tricentis.com/register
${Browser}        Chrome
${F_Gender}       F
${M_Gender}       M
${Email}          tryingtesttohard@gmail.com
${Password}       Teuing123
${ConfirmPassword}    Teuing123
${URL_Login}      https://demowebshop.tricentis.com/login

*** Test Cases ***
TC_Register
    [Documentation]    Register with valid data user
    Open Browser    ${URL_Register}    ${Browser}
    sleep    2
    Select Radio Button    Gender    ${M_Gender}
    sleep    2
    Input Text    id=FirstName    ${F_Name}
    sleep    2
    Input Text    id=LastName    ${L_Name}
    sleep    2
    Input Text    id=Email    ${Email}
    sleep    2
    Input Text    id=Password    ${Password}
    sleep    2
    Input Text    id=ConfirmPassword    ${ConfirmPassword}
    sleep    2
    Click element    id=register-button
    sleep    3
    Get Text    //div[@class='result']/text()/parent::node()
    Close Browser

TC_LOGIN
    [Documentation]    Login with Registered User
    Open Browser    ${URL_Login}    ${Browser}
    sleep    2
    Input Text    id=Email    ${Email}
    sleep    2
    Input Text    id=Password    ${Password}
    sleep    2
    Click element    //*[@class="button-1 login-button"]
    sleep    2
    Get text    //*[@class="topic-html-content-header"]
    sleep    2
    Close Browser
