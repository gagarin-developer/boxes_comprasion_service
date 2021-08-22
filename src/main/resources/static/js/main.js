$(function () {

  //Post sizes boxes
  $('#save-task').click(function () {
    var data = {};
    var dataArray = $('#task-form form').serializeArray();
    for (i in dataArray) {
      data[dataArray[i]['name']] = dataArray[i]['value'];
    }
    $.ajax({
      type: "POST",
      url: '/boxes/compare',
      data: JSON.stringify(data),
      contentType: 'application/json',
      dataType: "json",
      success: function (response) {
        $('#boxes-form').css('display', 'none');
        location.reload();
      },
      error: function (response) {
        if (response.status === 400) {
          alert('Ошибка, пустое пустое тело запроса');
        }
      }
    });
    return false;
  });
});