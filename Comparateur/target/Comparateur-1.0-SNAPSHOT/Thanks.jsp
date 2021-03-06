<%@page import="java.io.PrintWriter"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta http-equiv="pragma" content="no-cache" />
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.2/css/all.min.css" integrity="sha512-HK5fgLBL+xu6dm/Ii3z4xhlSUyZgTT9tuc/hSrtw6uzJOvgRr2a9jyxxT1ely+B+xFAmJKVSTbpM/CuL7qxO8w==" crossorigin="anonymous" />
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/bootstrap-datepicker/1.4.1/css/bootstrap-datepicker3.css" />
    <link rel="stylesheet" href="ressource/css/style.css">
    <link rel="icon" href="../assets/images/large_fligght.ico" type="image/png">
    <title>Fligght || Travel with ease </title>
</head>

<body>
    <div class="container-fluid" id="thanks-container">
        <div class="thanks-message text-center">
            <h1>Thanks! You're Awesome.<span> Seriously.</span></h1>
            ${infos}
            ${soso}

        </div>
        <div class="thanks-quote ">
            <i class="fas fa-quote-left"></i>
            <h1>Adenvture Is Worthwhile</h1>
            <i class="fas fa-quote-right"></i>
        </div>
        <div class="thanks-home-link">
            <a href="Home.jsp">
                Home
            </a>
        </div>

    </div>


    <script src="https://code.jquery.com/jquery-3.5.1.slim.min.js " integrity="sha256-4+XzXVhsDmqanXGHaHvgh1gMQKX40OUvDEBTu8JcmNs=" crossorigin=" anonymous "></script>
    <script type="text/javascript " src="https://cdnjs.cloudflare.com/ajax/libs/bootstrap-datepicker/1.4.1/js/bootstrap-datepicker.min.js "></script>
</body>

</html>