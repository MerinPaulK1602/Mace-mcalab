$(document).ready(function () {
    // Init
    $('.image-section').hide();
    $('.loader').hide();
    $('#result').hide();

    // Upload Preview
    function readURL(input) {
        if (input.files && input.files[0]) {
            var reader = new FileReader();
            reader.onload = function (e) {
                $('#imagePreview').css('background-image', 'url(' + e.target.result + ')');
                $('#imagePreview').hide();
                $('#imagePreview').fadeIn(650);
            }
            reader.readAsDataURL(input.files[0]);
        }
    }
    $("#imageUpload").change(function () {
        $('.image-section').show();
        $('#btn-predict').show();
        $('#result').text('');
        $('#result').hide();
        readURL(this);
    });

    



    // Predict
    $('#btn-predict').click(function () {
        var form_data = new FormData($('#upload-file')[0]);

        // Show loading animation
        $(this).hide();
        $('.loader').show();

        // Make prediction by calling api /predict
        $.ajax({
            type: 'POST',
            url: '/predict',
            data: form_data,
            contentType: false,
            cache: false,
            processData: false,
            async: true,
            success: function (data) {
                // Get and display the result
                $('.loader').hide();
                $('#result1').fadeIn(600);
                $('#result2').fadeIn(600);
                $('#result3').fadeIn(600);
                $('#result1').text('ResNet18: ' + data['model1']);
                $('#result2').text('VGG16: ' + data['model2']);
                $('#result3').text('VGG19: ' + data['model3']);
                console.log('Success!');
                $('#btn-predict').prop('disabled', false);
            },
        });
    });
    /*$('#btn-resnet18').click(function () {
        var form_data = new FormData($('#upload-file')[0]);

        // Show loading animation
        $(this).hide();
        $('.loader').show();

        // Make prediction by calling api /predict
        $.ajax({
            type: 'POST',
            url: '/predict',
            data: form_data,
            contentType: false,
            cache: false,
            processData: false,
            async: true,
            success: function (data) {
                // Get and display the result
                $('.loader').hide();
                $('#result1').fadeIn(600);
                $('#result1').text(' Result:  ' + data);
                console.log('Success!');
            },
        });
    });

    $('#btn-vgg16').click(function () {
        var form_data = new FormData($('#upload-file')[0]);

        // Show loading animation
        $(this).hide();
        $('.loader').show();

        // Make prediction by calling api /predict
        $.ajax({
            type: 'POST',
            url: '/predict',
            data: form_data,
            contentType: false,
            cache: false,
            processData: false,
            async: true,
            success: function (data) {
                // Get and display the result
                $('.loader').hide();
                $('#result2').fadeIn(600);
                $('#result2').text(' Result:  ' + data);
                console.log('Success!');
            },
        });
    });


    $('#btn-vgg19').click(function () {
        var form_data = new FormData($('#upload-file')[0]);

        // Show loading animation
        $(this).hide();
        $('.loader').show();

        // Make prediction by calling api /predict
        $.ajax({
            type: 'POST',
            url: '/predict',
            data: form_data,
            contentType: false,
            cache: false,
            processData: false,
            async: true,
            success: function (data) {
                // Get and display the result
                $('.loader').hide();
                $('#result3').fadeIn(600);
                $('#result3').text(' Result:  ' + data);
                console.log('Success!');
            },
        });
    });
    
    function predictWithModel(model) {
        var form_data = new FormData($('#upload-file')[0]);

        // Show loading animation
        $(this).hide();
        $('.loader').show();

        // Make prediction by calling api /predict
        $.ajax({
            type: 'POST',
            url: '/predict',
            data: form_data,
            contentType: false,
            cache: false,
            processData: false,
            async: true,
            success: function (data) {
                // Get and display the result
                $('.loader').hide();
                $('#result-' + model).fadeIn(600); // Change to show the corresponding result section
                $('#result-' + model).text(' Result:  ' + data);
                console.log('Success!');
            },
        });
    }*/

    $('#btn-resnet18').click(function () {
        predictWithModel('ResNet18');
    });
    
    $('#btn-vgg16').click(function () {
        predictWithModel('VGG16');
    });
    
    $('#btn-vgg19').click(function () {
        predictWithModel('VGG19');
    });
    
    function predictWithModel(model) {
        var form_data = new FormData($('#upload-file')[0]);
    
        // Show loading animation
        $('.loader').show();
    
        // Make prediction by calling api /predict
        $.ajax({
            type: 'POST',
            url: '/predict',
            data: form_data,
            contentType: false,
            cache: false,
            processData: false,
            async: true,
            success: function (data) {
                // Get and display the result
                $('.loader').hide();
                if (model === 'ResNet18') {
                    $('#result1').text(' ResNet18: ' + data['model1']);
                    $('#result2').text('');
                    $('#result3').text('');
                } else if (model === 'VGG16') {
                    $('#result2').text(' VGG16: ' + data['model2']);
                    $('#result1').text('');
                    $('#result3').text('');
                } else if (model === 'VGG19') {
                    $('#result3').text(' VGG19: ' + data['model3']);
                    $('#result1').text('');
                    $('#result2').text('');
                }
                console.log('Success!');
            },
        });
    }
    


});