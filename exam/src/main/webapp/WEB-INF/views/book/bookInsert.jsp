<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
    <h3>게시글 등록</h3>
    <form action='bookInsert' method="POST" onsubmit="return false" name="insertForm">
        <div>
            <label>도서번호 : <input type="number" value="${ bookInfo.bookNo }" name="bookNo" readonly></label>
        </div>
        <div>
            <label>도서명 : <input type="text" name="bookName"></label>
        </div>
        <div>
            <label>도서표지 : <input type="text" name="bookCoverimg"></label>
        </div>
        <div>
            <label>출판일자 : <input type="date" name="bookDate"></label>
        </div>
        <div>
            <label>금액 : <input type="number" name="bookPrice"></label>
        </div>
        <div>
            <label>출판사 : <input type="text" name="bookPublisher"></label>
        </div>
        <div>
            <label>도서소개 : <textarea name="bookInfo" cols="25" rows="10"></textarea></label>
        </div>
    
        <button type="submit">등록</button>
        <button type="button" onclick="location.href='getBookList'">조회</button>
    </form>
    <script>

        function formOptionChk() {
            let bookName = document.getElementsByName('bookName')[0];
            let writer = document.getElementsByName('writer')[0];
            let contents = document.getElementsByName('contents')[0];

            if(bookName.value == "") {
                alert("제목이 입력되지 않았습니다.")
                bookName.focus();
                return;
            }

            alert("도서등록이 완료 되었습니다.")

            insertForm.submit();
        }
        document.querySelector('button[type="submit"]').addEventListener("click", formOptionChk);
    </script>
</body>
</html>