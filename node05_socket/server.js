/**
 * http://usejsdoc.org/
 */

//모듈 추출(로딩)
var http=require('http');
var fs=require('fs');
var socketio=require('socket.io');

//서버생성
var server=http.createServer();
//서버에 소켓을 연결한다.
var io=socketio.listen(server);

//on() : 이벤트를 등록한다.
server.on('request',function(req,res){
	fs.readFile('chat.html',function(error,data){
		res.writeHead(200,{'Content-Type':'text/html;charset=UTF-8'});
		res.end(data);
	});
});//end server.on('request')//////////////////////

//클라이언트가 소켓(채팅)에 연결을 하면
io.sockets.on('connection',function(socket){
	socket.on('message',function(data){
		//emit() 강제적으로 이벤트 발생
		io.sockets.emit('message',data);
	});
});


server.listen(3000,function(){
	console.log('Server Running at http://127.0.0.1:3000');
});
