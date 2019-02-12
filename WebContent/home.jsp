<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>Document</title>
    <style>
        *{
            margin: 0;
            padding: 0;
        }
        body{
            width: 100%;
            overflow: hidden;
            background-color: darkslateblue;
        }
        .clearfix:after{
            content: "";
            display: block;
            clear: both;
            height: 0;
            visibility: hidden;
        }
        .parent{
            margin: 0 auto;
            display: flex;
            flex-wrap: wrap;
            justify-content: space-around;
            align-content: space-around;
        }
        .row div{
            width: 400px;
            height: 400px;
            margin: 6% 0;
            color: white;
            text-align:center;
            line-height: 400px;
            background-color: darkcyan;
            border-radius: 5px;
            transition: all 1s ease;
        }
        .row div:hover{
            font-size: 20px;
            background-color:cyan;
            transform: scale(1.03);
            box-shadow: 2px 2px 2px cadetblue;
        }
    </style>
</head>
<body>
    <div class="parent">
        <div class="row clearfix">
            <div class="show">
                My LivingSpace
            </div>
            <div class="add">
                Record My Life 
            </div>
        </div>
        <div class="row clearfix">
            <div class="del">
                Clear slice of life
            </div>
            <div class="up">
                Update slice of life
            </div>
        </div>
    </div>
    <script src="./js/jquery-3.1.1.js"></script>
    <script>
    	$(function(){
    		$(".row div").on("click",function(){
    			var cls = $(this).attr("class");
    			location.href = "homeServlet?action="+cls;
    		})
    	})
    </script>
</body>
</html>