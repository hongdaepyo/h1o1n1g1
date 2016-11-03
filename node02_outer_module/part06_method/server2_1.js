/**
 * http://usejsdoc.org/
 */
//포스트 방식일때에는 이벤트를 걸어서 가져오고
//겟 방식일때에는 URL을 가져와서 처리함


var http=require('http');
var fs=require('fs');
var url=require('url');
var querystring=require('querystring');

var server=http.createServer(function(req, resp){
	//동기화: 요청이 들어왔을때 서버에서 응답이 올때까지 클라이언트에서는 다른 동작을 못함
	//비동기화: 요청했을때 응답과는 상관없이 클라이언트가 동작가능
	var parsed=url.parse(req.url,false);
	if(parsed.pathname=='/'){
		//               읽어올 파일 경로와 이름,   error가 발생하면 error에 정상작동하면 data에 결과를 저장
		fs.readFile('part06_method/main2.html',function(error, data){
			resp.writeHead(200,{'Content-Type':'text/html;charset=UTF-8'});
			resp.end(data);
		});
	}else if(parsed.pathname=='/list'){
		var param=querystring.parse(parsed.query);
		var aParam=param.data_a;
		var bParam=param.data_b;
		resp.writeHead(200, {'Content-Type':'text/html;charset=UTF-8'});
		resp.end('<div><p>'+aParam+'</p><p>'+bParam+'</p></div>');
	}
});//end server///////////////////////////////////////

//웹서버 설정
server.listen(3000,function(){
	console.log('server running at http://127.0.0.1:3000');
});