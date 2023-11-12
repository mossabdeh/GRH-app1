<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>Login</title>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.1/css/all.min.css">
    <!-- Add your custom styles.css if needed -->

    <!-- Add Bootstrap's JavaScript and Popper.js -->
    <script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.0.9/dist/umd/popper.min.js"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>

    <script>
        $(document).ready(function () {
            // Enable Bootstrap tooltips
            $('[data-toggle="tooltip"]').tooltip();
        });
    </script>
</head>
<body>

<div class="container mt-5">
    <form class="col-md-6 mx-auto" action="<%= request.getContextPath() %>/login" method="post">
        <!-- Error message for bad credentials -->
        <% String errorMessage = (String) request.getAttribute("errorMessage"); %>
        <% if (errorMessage != null) { %>
            <div class="alert alert-danger" role="alert">
                <%= errorMessage %>
            </div>
        <% } %>

        <!-- Email input with caption-style tooltip -->
        <div class="form-group">
            <label for="form2Example1">
                Username
                <!-- Tooltip trigger -->
                <i class="fas fa-question-circle" data-toggle="tooltip" data-container="body" data-placement="top"
                   title="Dummy user: username = admin, password = admin."></i>
            </label>
            <input type="text" class="form-control" id="form2Example1" name="username" />
        </div>

        <!-- Password input -->
        <div class="form-group">
            <label for="form2Example2">Password</label>
            <input type="password" class="form-control" id="form2Example2" name="password" />
        </div>

        <!-- 2 column grid layout for inline styling -->
        <div class="row mb-4">
            <div class="col d-flex justify-content-center">
                <!-- Checkbox -->
                <div class="form-check">
                    <input class="form-check-input" type="checkbox" value="" id="form2Example31" checked />
                    <label class="form-check-label" for="form2Example31"> Remember me </label>
                </div>
            </div>

            <div class="col">
                <!-- Simple link -->
                <a href="#!" class="float-right">Forgot password?</a>
            </div>
        </div>

        <!-- Submit button -->
        <button type="submit" class="btn btn-primary btn-block mb-4">Log in</button>

        <!-- Register buttons -->
        <div class="text-center">
            <p>Welcome to SOACC <a href="#!">Application</a></p>
            <p>or sign up with:</p>
            <button type="button" class="btn btn-link btn-floating mx-1">
                <i class="fab fa-facebook-f"></i>
            </button>

            <button type="button" class="btn btn-link btn-floating mx-1">
                <i class="fab fa-google"></i>
            </button>

            <button type="button" class="btn btn-link btn-floating mx-1">
                <i class="fab fa-twitter"></i>
            </button>

            <button type="button" class="btn btn-link btn-floating mx-1">
                <i class="fab fa-github"></i>
            </button>
        </div>
    </form>
</div>

</body>
</html>
