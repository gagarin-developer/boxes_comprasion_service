$(function () {
  //Closing result form
  $('#result-form').click(function (event) {
    if (event.target === this) {
      $(this).css('display', 'none');
    }
  });

  //Post sizes boxes
  $('#compare-boxes').click(function () {
    $('#result-form').css('display', 'flex');
    var data1 = {};
    var data2 = {};
    var dataArray1 = $('#first-box-form form').serializeArray();
    var dataArray2 = $('#second-box-form form').serializeArray();
    for (i in dataArray1) {
      data1[dataArray1[i]['name']] = dataArray1[i]['value'];
      data2[dataArray2[i]['name']] = dataArray2[i]['value'];
    }
      var data3 = {'first':data1,'second':data2};

    $.ajax({
      url: '/boxes/compare',
      type: "POST",
      dataType: "text",
      data: JSON.stringify(data3),
      contentType: 'application/json',
      success: function (response) {
        $('#result-form form output').html(response);

      },
      error: function (error) {
        if (error.status === 400 || error.status === 500) {
          alert('Ошибка введенных данных');
        }
      }
    });
    return false;
  });
});