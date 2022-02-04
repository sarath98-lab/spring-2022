// Rock Paper Scissors game playing method
function playGame(humanValue) {
    botValue = random()
    humanWeapon = valueToWeapon(humanValue)
    botWeapon = valueToWeapon(botValue)

    document.getElementById("match").innerHTML = "<span id='weapon1'>" + humanWeapon + " </span> " + botWeapon
    document.getElementById("result").innerHTML = fightResult(humanValue, botValue)
}
// Random number between 0 to 2
function random() {
    return Math.floor(Math.random() * 3);
}
// Number value to weapon item convertor
function valueToWeapon(value) {
    if(value === 0) {
        return "Rock"
    }else if(value == 1) {
        return "Paper"
    }else {
        return "Scissors"
    }
}
// Fight result
function fightResult(human, bot) {
    msg = ""
    if(human === bot) {
        msg = "Tie! Tough fight try again :)"
    }else if((human+1)%3 === bot) {
        msg = "You lost! Better luck next time :("
    }else {
        msg = "You won! Nice :)"
    }
    return msg
}
