
//get current date
function currentDate(){
var currentdate = new Date(); 
var dateTime =  currentdate.getFullYear() + "-"+ (currentdate.getMonth()+1)  + "-" + currentdate.getDate();
document.getElementById("data").defaultValue=dateTime;
}
