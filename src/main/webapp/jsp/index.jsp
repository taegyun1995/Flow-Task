<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="/static/css/style.css" type="text/css">
    <title>파일 확장자 차단</title>
</head>
<body>
    <div class="fixed-extensions-container">
        <h3 class="title">고정 확장자</h3>
        <div id="fixed-extensions-items">
        </div>
    </div>

    <div class="custom-extensions-container">
        <h3 class="title">커스텀 확장자</h3>
        <div class="added-items-container">
            <input type="text" id="custom-extension-input" placeholder="확장자 입력">
            <button onclick="addCustomExtension()">추가</button>
            <div class="added-items-wrapper">
                <div id="added-items-count"></div>
                <span id="added-items-extensions"></span>
            </div>
        </div>
    </div>

    <script src="/static/js/script.js"></script>
</body>
</html>