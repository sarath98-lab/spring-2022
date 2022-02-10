
function getGithubInfo(user) {
    //1. Create an instance of XMLHttpRequest class and send a GET request using it.
    // The function should finally return the object(it now contains the response!)
    var xhr = new XMLHttpRequest();
    // GET api call git to fetch user details
    xhr.open('GET', 'https://api.github.com/users/'+user, false);
    xhr.send();
    return xhr;
}

function showUser(user) {
    //2. set the contents of the h2 and the two div elements in the div '#profile' with the user content
    // Setting content of user on web page
    $("#profile").children('h2').text(user.name);
    $(".avatar").html("<img src='"+user.avatar_url+"'>");
    $(".information").html("<div class='col-md-12'>ID: "+user.id+"</div>");
    $(".github-link").html("Github link: <a href='"+user.html_url+"'> "+user.html_url+" </a>");
}

function noSuchUser(username) {
    //3. set the elements such that a suitable message is displayed
    // Clearing the content and showing no such user msg
    $("#profile").children('h2').text("No such user please try different username!");
    $(".avatar").text("");
    $(".information").text("");
    $(".github-link").text("");
}

$(document).ready(function () {
    $(document).on('keypress', '#username', function (e) {
        //check if the enter(i.e return) key is pressed
        if (e.which == 13) {
            //get what the user enters
            username = $(this).val();
            //reset the text typed in the input
            $(this).val("");
            //get the user's information and store the respsonse
            response = getGithubInfo(username);
            //if the response is successful show the user's details
            if (response.status == 200) {
                showUser(JSON.parse(response.responseText));
                //else display suitable message
            } else {
                noSuchUser(username);
            }
        }
    })
});