$(function(){
    var select = $(".numbers");
    for (i=1;i<=100;i++){
        select.append($('<option></option>').val(i).html(i));
    }
});