//빈 객체를 선언
var calc = {}//자바에서 test t = new test()와 같은의미

//멤버변수 추가
calc.x = 0;
calc.y = 0;

//멤버함수
calc.setValue = function(p1,p2){
	this.x = p1;
	this.y = p2;	
}
calc.plus = function(){
	return this.x + this.y;
}
calc.minus = function(){
	return this.x - this.y;
}
clac.result = function(){
	var value1 =this.plus();
	var value2 =this.minus();
	
	document.write("<p>덧셈 = "+value1 + "</p>");
	document.write("<p>뺄셈 = "+value2 + "</p>");
}