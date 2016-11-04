/**
 * http://usejsdoc.org/
 */

//npm_install_ejs

var http=require('http');
var url=require('url');
var fs=require('fs');
var ejs=require('ejs');

var server=http.createServer(function(req,res){
	var urlObj=url.parse(req.url,true);
	//var urlObj=url.parse(req.url);
	if(urlObj.pathname=="/"){
		fs.readFile('part03_ejs/page1.ejs','UTF-8',function(error, data){
			res.writeHead(200,{'Content-Type':'text/html;charset=UTF-8'});
			//ejs페이지를 HTML페이지로 바꾸어 제공하는 코드가 된다.
			res.end(ejs.render(data));
		});
	}else if(urlObj.pathname=='/memInsert'){
		var fname=urlObj.query.fname;
		/*var parsed=querystring.parse(urlObj.query);
		var fname=parsed.fname;*/
		fs.readFile('part03_ejs/page2.ejs','UTF-8',function(error,data){
			res.writeHead(200,{'Content-Type':'text/html;charset=UTF-8'});
			res.end(ejs.render(data,{fname:fname}));
		});
	}
});

server.listen(3000,function(){
	console.log('Server Running at http://127.0.0.1:3000');
});