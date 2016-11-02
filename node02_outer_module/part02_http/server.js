/**
 * http://usejsdoc.org/
 */

//http 모듈을 추출한다.
var http=require('http');

//웹서버 생성
var server=http.createServer(function(request, response){
	response.writeHead(200,{'Content-Type':'text/html;charset=UTF-8'});
	response.end('<h1>Hello world</h1>');
});

//웹서버 실행
server.listen(3000, function(){
	console.log('server running at http://127.0.0.1:3000');
});