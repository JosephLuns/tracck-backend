API Details

Local Register 

http://50.63.13.121:8082/public/rest/user/register

Params:

username
mobile
password

-- On Success you will get Customer Data as below:-
{
    "userid": "2",
    "username": "swayam1",
    "email": null,
    "status": "success",
    "error": "",
    "mobile": "1234567890"
}

-- On Error, when customer already exits with same mobile 

{
    "userid": null,
    "username": null,
    "email": null,
    "status": "failure",
    "error": "User Already Exists!",
    "mobile": null
}

2. Local Login 

http://50.63.13.121:8082/public/rest/user/login

Params:

mobile
password



-- On Success you will get Customer Data as below:-

{
    "userid": "1",
    "username": "swayam",
    "email": null,
    "status": "success",
    "error": "",
    "mobile": "123456789"
}

-- On Error, when invalid credentails 

{
    "userid": null,
    "username": null,
    "email": null,
    "status": "failure",
    "error": "Invalid Credentials",
    "mobile": null
}

3. Amazon Login 

http://localhost:8082/public/rest/amazon/login

Header

userid
password
locale


