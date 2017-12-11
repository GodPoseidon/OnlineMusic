$(function(){
	$("#allSong").click(allSong);
	$("#mySong").click(mySong);
	$("#myCollect").click(myCollect);
});

function allSong(){
	$("#iframe").attr("src","person/allsong");
}

function mySong(){
	$("#iframe").attr("src","person/mysongs");
}
function myCollect(){
	$("#iframe").attr("src","person/mycollect");
}