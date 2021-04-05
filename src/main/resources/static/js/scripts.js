function quantity() {
    var select = $(".numbers");
    for (let i=1;i<=100;i++){
        select.append($('<option></option>').val(i).html(i));
    }
}