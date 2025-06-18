function addToCart(bookid) {
    if (confirm("장바구니에 도서를 추가합니까?") == true) {
        document.addForm.action="/BookMarket/cart/book/"+bookid;
        document.addForm.submit();
    }
}
function removeFromCart(bookid, cartId) {
    document.removeForm.action="/BookMarket/cat/book/"+bookid;
    document.removeForm.submit();
    setTimeout('location.reload()',10);
}