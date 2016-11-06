/**
 * Created by Çağatay Han on 6.11.2016.
 */
$(document).ready(function () {
    getAllUsers();

    var userId;
    $('.tableBody').on('click', '.upButton', function () {
        userId = $(this).attr('data-id');
    });

    $('body').on('click', '.deneme', function () {
        getUserById();
    });

    $('#myform').validate({
        rules: {
            name: {
                required: true
            },
            surname: {
                required: true
            }
        }
    });

    var obj = {};
    function getUserById() {
        $.ajax({
            type: "GET",
            url: '/get/' + userId,
            dataType: 'json',
            async: false,
            contentType: 'application/json',
            success: function (data) {
                obj = data;
            },
            error: function (data) {
                alert("error");
            }
        });
    }

    function getAllUsers() {
        $.ajax({
            type: "GET",
            url: '/getAll',
            dataType: 'json',
            contentType: 'application/json',
            success: function (data) {
                var tableBody = $('.tableBody');
                tableBody.html("");
                $.each(data, function (i, items) {
                    var id = tableBody.append(
                        '<tr>' +
                        '<td>' + items.name + '</td>' +
                        '<td>' + items.surname + '</td>' +
                        '<td>' + items.phone + '</td>' +
                        '<td><div class="updateButton"><button class="btn btn-primary upButton" data-toggle="modal" data-id='+ items.id +' data-target="#updateModal">Update</button></div></td>' +
                        '<td><div class="removeButton"><button class="btn btn-primary deleteButton" data-toggle="modal" data-id='+ items.id +' data-target="#deleteModal">Remove</button></div></td>' +
                        '</tr>');
                });
            },
            error: function () {
                console.log("error")
            }
        });
    }

    var id;
    $('.tableBody').on('click', '.deleteButton', function () {
        id = $(this).attr('data-id');
    });

    $('.modalDeleteButton').click(function () {
        $.ajax({
            type: "GET",
            url: '/delete/' + id,
            dataType: 'html',
            cache: false,
            success: function (data) {
                getAllUsers();
            },
            error: function (data) {
                alert(data);
            }
        });
    });

    (function ($) {
        $.fn.serializeFormJSON = function () {
            var o = {};
            var a = this.serializeArray();
            $.each(a, function () {
                if (o[this.name]) {
                    if (!o[this.name].push) {
                        o[this.name] = [o[this.name]];
                    }
                    o[this.name].push(this.value || '');
                } else {
                    o[this.name] = this.value || '';
                }
            });
            return o;
        };
    })(jQuery);

    $('#addModalForm').submit(function (e) {
        e.preventDefault();
        var data = $(this).serializeFormJSON();
        $.ajax({
            type: "POST",
            url: "/",
            data: JSON.stringify(data),
            contentType : 'application/json; charset=utf-8',
            dataType : 'json',
            success: function () {
                getAllUsers();
            },
            error: function () {
                alert("Error");
            }
        });
    });

    var updateId;
    $('.tableBody').on('click', '.upButton', function () {
        updateId = $(this).attr('data-id');
        getUserById();
        $('.nameData').val(obj.name);
        $('.surnameData').val(obj.surname);
        $('.phoneData').val(obj.phone);
    });

    $('#updateModalForm').submit(function (e) {
        e.preventDefault();
        var data = $(this).serializeFormJSON();
        $.ajax({
            type: "POST",
            url: '/update/' + updateId,
            data: JSON.stringify(data),
            contentType : 'application/json; charset=utf-8',
            dataType : 'json',
            success: function () {
                getAllUsers();
            },
            error: function () {
                alert(data);
            }
        })
    });

    $('#addModalForm').on('hidden', function () {
        $('.nameDataAdd').val('sadsad');
        $('.surnameDataAdd').val('');
        $('.phoneDataAdd').val('');
    });
});
