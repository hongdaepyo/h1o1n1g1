/**
 * http://usejsdoc.org/
 */

var http=require('http');
var fs=require('fs');
var querystring=require('querystring');

var server=http.createServer(function(req, resp){
	//동기화: 요청이 들어왔을때 서버에서 응답이 올때까지 클라이언트에서는 다른 동작을 못함
	//비동기화: 요청했을때 응답과는 상관없이 클라이언트가 동작가능
	if(req.method=='GET'){
		//               읽어올 파일 경로와 이름,   error가 발생하면 error에 정상작동하면 data에 결과를 저장
		fs.readFile('part06_method/main.html',function(error, data){
			resp.writeHead(200,{'Content-Type':'text/html;charset=UTF-8'});
			resp.end(data);
		});
	}else if(req.method=='POST'){
		var res='';
		//'data' 이벤트가 발생이 되면 res변수에 parameter값을 추가한다. 
		req.on('data',function(data){
			res+=data;
		});
		
		//client 요청이 끝났으면...
		req.on('end',function(){
			//console.log(typeof(res)); //string
			//문자열을 json객체로 변환하다.
			//{ data_a: 'werwer', data_b: 'qweqwe' }  <= 이렇게 나옴
			var parsed=querystring.parse(res);
			var aParam=parsed.data_a;
			var bParam=parsed.data_b;
			resp.writeHead(200, {'Content-Type':'text/html;charset=UTF-8'});
			resp.end('<div><p>'+aParam+'</p><p>'+bParam+'</p></div>');
		});
	}
});//end server///////////////////////////////////////

//웹서버 설정
server.listen(3000,function(){
	console.log('server running at http://127.0.0.1:3000');
});