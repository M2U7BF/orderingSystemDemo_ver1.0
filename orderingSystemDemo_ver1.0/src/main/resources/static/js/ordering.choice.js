/**
 * 
 */

 function showSelectedItem(tr){
    let id;
    id = $(tr).data("id");

    if (!($("#selectedItem" + id).length)) {
        let name;
        let salesUnit;
        let price;

        name = $(".foodListItem[data-id=" + id + "]").children(".name").text();
        salesUnit = $(".foodListItem[data-id=" + id + "]").children(".salesUnit").text();
        price = $(".foodListItem[data-id=" + id + "]").children(".price").text();

        $("#selectedList").append(
            "\<tr class=\"selectedItem\" id=\"selectedItem" + id + "\"\>" +
            "\<td\>" +
            id +
            "<input type=\"hidden\" name=\"id\" value=\"" + id + "\">" +
            "\<\/td\>" +
            "\<td\>" +
            name +
            "<input type=\"hidden\" name=\"name\" value=\"" + name + "\">" +
            "\<\/td\>" +
            "\<td\>" +
            salesUnit +
            "<input type=\"hidden\" name=\"salesUnit\" value=\"" + salesUnit + "\">" +
            "\<\/td\>" +
            "\<td\>" +
            price +
            "<input type=\"hidden\" name=\"price\" value=\"" + price + "\">" +
            "\<\/td\>" +
            "\<td\>" +
            "\<select name=\"numPurchase\" id=\"numPurchases" + id + "\" onchange=\"calcTotal(" + price + "," + id + ")\" placeholder='個数'\>" +
            "\<option\>0\<\/option\>" +
            "\<option\>1\<\/option\>" +
            "\<option\>2\<\/option\>" +
            "\<option\>3\<\/option\>" +
            "\<option\>4\<\/option\>" +
            "\<option\>5\<\/option\>" +
            "\<option\>6\<\/option\>" +
            "\<option\>7\<\/option\>" +
            "\<option\>8\<\/option\>" +
            "\<option\>9\<\/option\>" +
            "\<option\>10\<\/option\>" +
            "\<option\>11\<\/option\>" +
            "\<option\>12\<\/option\>" +
            "\<option\>13\<\/option\>" +
            "\<option\>14\<\/option\>" +
            "\<option\>15\<\/option\>" +
            "\<\/select\>" +
            "\<\/td\>" +
            "\<td\>" +
            "<span id=\"total" + id + "\" class=\"total\" >0</span>" +
            "<input type=\"hidden\" name=\"total\" id=\"total_input" + id + "\" value=\"0\" \>" +
            "\<\/td\>" +
            "\<td\>\<button onclick=\"removeItem(this," + id + ")\" class=\"deleteButton\"\>削除する\<\/button\>\<\/td\>" +
            "\<\/tr\>");
    }

 }

function removeItem(button, id) {
    let parent = button.parentNode.parentNode;
    parent.remove();

    calcGrandTotal();
}

function calcTotal(price, id) {
    let amount = $("#numPurchases" + id).val();
    let total = Math.ceil(price * amount);

    $("#total" + id).text(total);
    $("#total_input" + id).attr('value', total);

    calcGrandTotal();
}

function calcGrandTotal() {
    let grandTotal = 0;
    $(".total").each(function (i, element) {
        let text = Number($(element).text());
        grandTotal += text;
    });
    grandTotal = Math.round(grandTotal * 1.08);
    $("#grandTotal").text(grandTotal);
    $("#grandTotal_input").attr("value", grandTotal);
}
