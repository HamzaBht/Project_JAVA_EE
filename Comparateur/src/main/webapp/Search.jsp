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
        <title>Fligght || Travel with ease</title>
    </head>

    <body>
        <div class="row">
            <div class="col-md-12 rectangle-20-C61RwL">
                <div class="group-14-C61RwL" data-id="1b1078a7-6df4-48cc-9aa6-630307eb5726">
                    <img class="intersection-2-AX7pWk" data-id="36c8bd0c-3358-4bbf-a7bd-5646928b4131" src="https://cdn.animaapp.com/projects/602d1c08d1681a1de21c2d38/releases/602d1da91186beac61c42d17/img/intersection-2@1x.png" anima-src="https://cdn.animaapp.com/projects/602d1c08d1681a1de21c2d38/releases/602d1da91186beac61c42d17/img/intersection-2@1x.png">
                    <div class="group-1-AX7pWk" data-id="28b094ec-0c37-4fd8-a565-336e82414c67">
                        <img class="subtraction-1-75u7LO" data-id="0427fe28-704e-4b16-ac70-77975d059344" src="https://cdn.animaapp.com/projects/602d1c08d1681a1de21c2d38/releases/602d1da91186beac61c42d17/img/subtraction-1@1x.png" anima-src="https://cdn.animaapp.com/projects/602d1c08d1681a1de21c2d38/releases/602d1da91186beac61c42d17/img/subtraction-1@1x.png">
                        <img class="intersection-1-75u7LO" data-id="3b548f02-63fa-42d2-9f8b-a4875b33031a" src="https://cdn.animaapp.com/projects/602d1c08d1681a1de21c2d38/releases/602d1da91186beac61c42d17/img/intersection-1@1x.png" anima-src="https://cdn.animaapp.com/projects/602d1c08d1681a1de21c2d38/releases/602d1da91186beac61c42d17/img/intersection-1@1x.png">
                    </div>
                </div>
                <div class="group-13-C61RwL" data-id="4bc6f347-3676-436e-a6fa-9cfe2d0df571">
                    <div class="home-about-us-flights-WQXeF1" data-id="0fb633f5-85a2-46fe-ad9b-598407f165c5">
                        <a href="Home.jsp">Home</a> <a href="Home.jsp#about">About us</a> <a href="Home.jsp#contact">Contact</a> <a href="Search.jsp" class="active">Flights</a>
                    </div>
                </div>
            </div>
        </div>
        <div class="search-block">
            <img class="mask-group-5-C61RwL" data-id="c538cadd-7b21-4d2f-b555-33be10bcf0e0" src="https://cdn.animaapp.com/projects/602d1c08d1681a1de21c2d38/releases/602d1da91186beac61c42d17/img/mask-group-5@1x.png" anima-src="https://cdn.animaapp.com/projects/602d1c08d1681a1de21c2d38/releases/602d1da91186beac61c42d17/img/mask-group-5@1x.png">
            <div class="row">
                <div class="find-the-b-ight-price-C61RwL" data-id="9b98df54-5c5d-4ad6-aecd-7d828b2967a7">Find the best flight for the right price</div>
                <form action="${pageContext.request.contextPath}/SearchRequest" class="form-group" method="POST" id="search-form">
                    <div class="input">
                        <input class="field-input" type="text" id="from" name="from" placeholder="From :">
                        <i class="fa fa-plane-departure fa-lg"></i>
                    </div>
                    <div class="input">
                        <input class="field-input" type="text" id="to" name="to" placeholder="To :"> <i class="fa fa-plane-arrival fa-lg"></i>
                    </div>
                    <div class="input">
                        <input class="field-input" type="date" id="depart" name="depart" placeholder="Depart :">

                    </div>
                    <div class="input">
                        <input class="field-input" type="date" id="return" name="return" placeholder="Return :">

                    </div>
                    <div class="input selectdiv">
                        <select id="class" name="class">
						<option value="Économie ">Économie</option>
                        <option value="Éco-premium">Éco-premium</option>
                        <option value="Première ">Première</option>
                        <option value="Affaire ">Affaire</option>
					    </select>
                    </div>
                    <div class="group-30-C61RwL " data-id="0d1367bb-6c04-4344-88b6-e70f3f449c3c ">
                        <button type="submit" class="search-button" data-id="0649b305-d540-4165-94d0-978ccfbddce8 ">Search flights </button>

                    </div>
                </form>
            </div>

        </div>
        <div class="row footer ">
            <div class="group-27-C61RwL " data-id="cc5adfb8-b328-481e-b7b4-85f3db56a1a9 ">
                <div class="copyright--s-reserved-BKbGut " data-id="10757f13-a948-40b8-9e4f-75598fd2bcd8 ">
                    <span class="span0-BjrVDn " style="margin-right: 5px;">Copyright
					© 2021 Made With ❤️ By </span> <span class="span1-BjrVDn "> MHJAH.
					All Rights Reserved</span>
                </div>
            </div>
        </div>
        
        ${infos}
        <script src="https://code.jquery.com/jquery-3.5.1.slim.min.js " integrity="sha256-4+XzXVhsDmqanXGHaHvgh1gMQKX40OUvDEBTu8JcmNs=" crossorigin=" anonymous "></script>
        <script type="text/javascript " src="https://cdnjs.cloudflare.com/ajax/libs/bootstrap-datepicker/1.4.1/js/bootstrap-datepicker.min.js "></script>
    </body>

    </html>