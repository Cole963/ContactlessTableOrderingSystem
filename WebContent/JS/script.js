/*UserAccountForm.jsp*/
/*----------------------------------------------------------------------*/
function userAccountFormValidation() {
    var fullname = document.getElementById("fullname");
    var username = document.getElementById("username");
    var password = document.getElementById("password");
    var email = document.getElementById("email");
    var fullnameVal = fullname.value.trim();
    var usernameVal = username.value.trim();
    var passwordVal = password.value;
    var emailVal = email.value.trim();
    var canSubmit = true;

    if (fullnameVal === '' || fullnameVal === null) {
        setFail(fullname, 'Name cannot be empty');
        canSubmit = false;
    } else if (!fullnameLengthValid(fullnameVal)) {
        setFail(fullname, 'Name cannot be longer than 70 characters');
        canSubmit = false;
    } else {
        setPass(fullname);
        fullname.value = fullnameVal;
    }

    if (usernameVal === '' || usernameVal === null) {
        setFail(username, 'Username cannot be empty');
        canSubmit = false;
    } else if (!usernameLengthValid(usernameVal)) {
        setFail(username, 'Username cannot be longer than 45 characters');
        canSubmit = false;
    } else if (!usernameFormatValid(usernameVal)) {
        setFail(username, 'Username can only contain lowercase letters, numbers, dots and underscore');
        canSubmit = false;
    } else {
        setPass(username);
        username.value = usernameVal;
    }

    if (passwordVal === '' || passwordVal === null) {
        setFail(password, 'Password cannot be empty');
        canSubmit = false;
    } else if (!passwordLengthValid(passwordVal)) {
        setFail(password, 'Password cannot be longer than 45 characters');
        canSubmit = false;
    } else if (!passwordFormatValid(passwordVal)) {
        setFail(password, 'Password cannot contain spaces');
        canSubmit = false;
    } else {
        setPass(password);
    }

    if (emailVal === '' || emailVal === null) {
        setFail(email, 'Email cannot be empty');
        canSubmit = false;
    } else if (!emailLengthValid(emailVal)) {
        setFail(email, 'Email cannot be longer than 45 characters');
        canSubmit = false;
    } else if (!emailFormatValid(emailVal)) {
        setFail(email, 'Email is invalid');
        canSubmit = false;
    } else {
        setPass(email);
        email.value = emailVal.toLowerCase();
    }
    return canSubmit;
}

function fullnameLengthValid(fullname) {
    /* 
      Name max length: 70
    */
    var valid = true;
    if (fullname.length > 70) {
        valid = false;
    }
    return valid;
}

function usernameLengthValid(username) {
    /* 
      Username max length: 45
    */
    var valid = true;
    if (username.length > 45) {
        valid = false;
    }
    return valid;
}

function usernameFormatValid(username) {
    /* 
      Username can only have: 
      - Lowercase Letters (a-z) 
      - Numbers (0-9)
      - Dots (.)
      - Underscores (_)
    */
    var valid = false;
    const usernameFormat = /^[a-z0-9_\.]+$/;
    if (username.match(usernameFormat)) {
        valid = true;
    }
    return valid;
}

function passwordLengthValid(password) {
    /* 
      Password max length: 45
    */
    var valid = true;
    if (password.length > 45) {
        valid = false;
    }
    return valid;
}

function passwordFormatValid(password) {
    /* 
      Password can only have: 
      - Non-whitespace characters
    */
    var valid = false;
    const passwordFormat = /^\S*$/;
    if (password.match(passwordFormat)) {
        valid = true;
    }
    return valid;
}

function emailLengthValid(email) {
    /* 
      Email max length: 45
    */
    var valid = true;
    if (email.length > 45) {
        valid = false;
    }
    return valid;
}

function emailFormatValid(email) {
    var valid = false;
    const emailFormat = /^(([^<>()\[\]\\.,;:\s@"]+(\.[^<>()\[\]\\.,;:\s@"]+)*)|(".+"))@((\[[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}])|(([a-zA-Z\-0-9]+\.)+[a-zA-Z]{2,}))$/;
    if (email.match(emailFormat)) {
        valid = true;
    }
    return valid;
}

function resetAccountFormDefault() {
    var fullname = document.getElementById("fullname");
    var username = document.getElementById("username");
    var password = document.getElementById("password");
    var email = document.getElementById("email");
    fullname.parentElement.className = 'form-group';
    username.parentElement.className = 'form-group';
    password.parentElement.className = 'form-group';
    email.parentElement.className = 'form-group';
}

/*UserProfileForm.jsp*/
/*----------------------------------------------------------------------*/
function userProfileFormValidation() {
    var profile = document.getElementById("profile");
    var description = document.getElementById("description");
    var profileVal = profile.value.trim();
    var descriptionVal = description.value.trim();
    var canSubmit = true;
    if (profileVal === '' || profileVal === null) {
        setFail(profile, 'Profile cannot be empty');
        canSubmit = false;
    } else if (!profileLengthValid(profileVal)) {
        setFail(profile, 'Profile cannot be longer than 70 characters');
        canSubmit = false;
    } else {
        setPass(profile);
        profile.value = profileVal;
    }

    if (!descriptionLengthValid(descriptionVal)) {
        setFail(description, 'Description cannot be longer than 70 characters');
        canSubmit = false;
    } else {
        setPass(description);
        description.value = descriptionVal;
    }
    return canSubmit;
}

function profileLengthValid(profile) {
    /* 
      Profile max length: 70
    */
    var valid = true;
    if (profile.length > 70) {
        valid = false;
    }
    return valid;
}

function descriptionLengthValid(description) {
    /* 
      Description max length: 70
    */
    var valid = true;
    if (description.length > 70) {
        valid = false;
    }
    return valid;
}

function resetProfileFormDefault() {
    var profile = document.getElementById("profile");
    var description = document.getElementById("description");
    profile.parentElement.className = 'form-group';
    description.parentElement.className = 'form-group';
}

/*LoginForm.jsp*/
/*----------------------------------------------------------------------*/
function loginValidation() {
    var username = document.getElementById("username");
    var password = document.getElementById("password");
    var usernameVal = username.value.trim();
    var passwordVal = password.value;
    var canSubmit = true;

    if (usernameVal === '' || usernameVal === null) {
        setFail(username, 'Username cannot be empty');
        canSubmit = false;
    } else if (!usernameLengthValid(usernameVal)) {
        setFail(username, 'Username cannot be longer than 45 characters');
        canSubmit = false;
    } else if (!usernameFormatValid(usernameVal)) {
        setFail(username, 'Username can only contain lowercase letters, numbers, dots and underscore');
        canSubmit = false;
    } else {
        setPass(username);
        username.value = usernameVal;
    }

    if (passwordVal === '' || passwordVal === null) {
        setFail(password, 'Password cannot be empty');
        canSubmit = false;
    } else if (!passwordLengthValid(passwordVal)) {
        setFail(password, 'Password cannot be longer than 45 characters');
        canSubmit = false;
    } else if (!passwordFormatValid(passwordVal)) {
        setFail(password, 'Password cannot contain spaces');
        canSubmit = false;
    } else {
        setPass(password);
    }
    return canSubmit;
}

/*MenuItemForm.jsp*/
/*----------------------------------------------------------------------*/
function menuItemFormValidation() {
    var name = document.getElementById("name");
    nameVal = name.value.trim();
    name.value = nameVal;

    var price = document.getElementById("price");
    var priceVal = price.value;
    price.value = Number(priceVal).toFixed(2);
}

/*Cart.jsp*/
/*----------------------------------------------------------------------*/
function promptMobileNum() {
    var mobileNum = document.getElementById("mobileNum");
    mobileNum = prompt("Please enter your mobile number:");

    if (mobileNum == null) {
        return false;
    } else if (!mobileNum.match(/^[0-9]{1,9}$/)) {
        alert("Invalid mobile number");
        return false;
    } else {
        document.getElementById("mobileNum").value = mobileNum;
        return true;
    }

}

/*OrderView.jsp & OrderItemView.jsp*/
/*----------------------------------------------------------------------*/
$(document).ready(function() {
    $('.toggleEditOrderItem').on('click', function() {
        var $this = $(this);
        var $first = $this.closest('tr').find('.toggleHide').eq(0);
        var $second = $this.closest('tr').find('.toggleHide').eq(1);
        var $third = $this.closest('tr').find('.toggleHide').eq(2);
        if ($first.css('visibility') == 'hidden') {
            $first.css('visibility', 'visible');
        } else {
            $first.css('visibility', 'hidden');
        }
        if ($second.css('visibility') == 'hidden') {
            $second.css('visibility', 'visible');
        } else {
            $second.css('visibility', 'hidden');
        }
        if ($third.css('visibility') == 'hidden') {
            $third.css('visibility', 'visible');
        } else {
            $third.css('visibility', 'hidden');
        }
    });
    $('.minus').on('click', function() {
        var qty = $(this).closest('tr').find("input[name='quantity']");
        var update = qty.val();
        if (update > 1) {
            update--;
        }
        qty.val(update);
    });
    $('.plus').on('click', function() {
        var qty = $(this).closest('tr').find("input[name='quantity']");
        var update = qty.val();
        update++;
        qty.val(update);
    });

    $('.toggleEditOrder').on('click', function() {
        var $this = $(this);
        var $first = $this.closest('tr').find('.toggleHide');
        var $second = $this.closest('tr').find('.toggleMobile');
        if ($first.css('visibility') == 'hidden') {
            $first.css('visibility', 'visible');
            $second.prop('readonly', false);
        } else {
            $first.css('visibility', 'hidden');
            $second.prop('readonly', true);
        }
    });

/*CouponView.jsp*/
/*----------------------------------------------------------------------*/
    document.getElementById('order-select').addEventListener('change', function(e) {
        if (e.target.value === "all") {
            document.location.href = "viewCoupons";
        } else if (e.target.value === "expired") {
            document.location.href = "viewCouponsExpired";
        } else if (e.target.value === "active") {
            document.location.href = "viewCouponsActive";
        }
    });
});

function validateMobileNum() {
    var mobileNum = document.getElementById("mobileNum").value;

    if (mobileNum == null || mobileNum == "") {
        alert("Mobile number cannot be empty");
        return false;
    } else if (!mobileNum.match(/^[0-9]{1,9}$/)) {
        alert("Invalid mobile number");
        return false;
    } else {
        document.getElementById("mobileNum").value = mobileNum;
        return true;
    }
}

/*Restaurant Owner*/
/*----------------------------------------------------------------------*/
function averageSpendDailyCheck() {
    var selected = document.getElementById("selectedDateVal").value;
    document.location.href = "viewDailyAverageSpendReport?selectedDateVal=" + selected;
}

function averageSpendMonthlyCheck() {
    var selected = document.getElementById("selectedMonthVal").value;
    document.location.href = "viewMonthlyAverageSpendReport?selectedMonthVal=" + selected;
}

function averageSpendWeeklyCheck() {

    var inputStartDate = document.getElementById("selectedDateVal1").value;
    var inputEndDate = document.getElementById("selectedDateVal2").value;

    //define two date object variables to store the date values  
    var startDate = new Date(inputStartDate);
    var endDate = new Date(inputEndDate);

    //calculate time difference  
    var time_difference = endDate.getTime() - startDate.getTime();

    //calculate days difference by dividing total milliseconds in a day  
    var days_difference = time_difference / (1000 * 60 * 60 * 24);

    if (inputStartDate != "" && inputEndDate != "" && days_difference <= 7) {
        document.location.href = "viewOwnerAverageSpendWeeklyReport?selectedDateVal1=" + inputStartDate + "&selectedDateVal2=" + inputEndDate;
    } else if (inputStartDate != "" && inputEndDate != "" && days_difference > 7) {
        alert("Both dates selected in range is " + days_difference + " days. Please select both dates again, it have to be less than or equal to 7 days. ");
    }
}

function drinksAndDishesDailyCheck() {
    var selected = document.getElementById("selectedDateVal").value;
    document.location.href = "viewOwnerDrinksAndDishesDailyReport?selectedDateVal=" + selected;
}

function drinksAndDishesMonthlyCheck() {
    var selected = document.getElementById("selectedMonthVal").value;
    document.location.href = "viewOwnerDrinksAndDishesMonthlyReport?selectedMonthVal=" + selected;
}

function drinksAndDishesWeeklyCheck() {

    var inputStartDate = document.getElementById("selectedDateVal1").value;
    var inputEndDate = document.getElementById("selectedDateVal2").value;

    //define two date object variables to store the date values  
    var startDate = new Date(inputStartDate);
    var endDate = new Date(inputEndDate);

    //calculate time difference  
    var time_difference = endDate.getTime() - startDate.getTime();

    //calculate days difference by dividing total milliseconds in a day  
    var days_difference = time_difference / (1000 * 60 * 60 * 24);

    if (inputStartDate != "" && inputEndDate != "" && days_difference <= 7) {
        document.location.href = "viewOwnerDrinksAndDishesWeeklyReport?selectedDateVal1=" + inputStartDate + "&selectedDateVal2=" + inputEndDate;
    } else if (inputStartDate != "" && inputEndDate != "" && days_difference > 7) {
        alert("Both dates selected in range is " + days_difference + " days. Please select both dates again, it have to be less than or equal to 7 days. ");
    }
}

function frequencyDailyCheck() {
    var selected = document.getElementById("selectedDateVal").value;
    document.location.href = "viewDailyFrequencyReport?selectedDateVal=" + selected;
}

function frequencyMonthlyCheck() {
    var selected = document.getElementById("selectedMonthVal").value;
    document.location.href = "viewMonthlyFrequencyReport?selectedMonthVal=" + selected;
}

function frequencyWeeklyCheck() {

    var inputStartDate = document.getElementById("selectedDateVal1").value;
    var inputEndDate = document.getElementById("selectedDateVal2").value;

    //define two date object variables to store the date values  
    var startDate = new Date(inputStartDate);
    var endDate = new Date(inputEndDate);

    //calculate time difference  
    var time_difference = endDate.getTime() - startDate.getTime();

    //calculate days difference by dividing total milliseconds in a day  
    var days_difference = time_difference / (1000 * 60 * 60 * 24);

    if (inputStartDate != "" && inputEndDate != "" && days_difference <= 7) {
        document.location.href = "viewOwnerFrequencyWeeklyReport?selectedDateVal1=" + inputStartDate + "&selectedDateVal2=" + inputEndDate;
    } else if (inputStartDate != "" && inputEndDate != "" && days_difference > 7) {
        alert("Both dates selected in range is " + days_difference + " days. Please select both dates again, it have to be less than or equal to 7 days. ");
    }
}

/*Common functions for form controls manipulation*/
/*----------------------------------------------------------------------*/
function setFail(input, message) {
    var formCtrl = input.parentElement;
    var small = formCtrl.querySelector('small');
    formCtrl.className = 'form-group fail';
    small.innerText = message;
}

function setPass(input) {
    var formCtrl = input.parentElement;
    formCtrl.className = 'form-group pass';
}

function trimSearchInput() {
    var input = document.getElementById("searchInput");
    inputVal = input.value.trim();
    input.value = inputVal;
}

/*General*/
/*----------------------------------------------------------------------*/
function logout() {
    return confirm("Are you sure you want to logout?");
}

function confirmUserAction(message) {
    return confirm(message);
}