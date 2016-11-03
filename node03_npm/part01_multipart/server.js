/**
 * http://usejsdoc.org/
 */

//C:\Study\workspace_spring\node03_npm
//npm install formidable

//http://127.0.0.1:3000/list

//모듈을 추출한다.
var http=require('http');
var formidable=require('formidable');
var fs=require('fs');


var paints=[];


//웹서버 생성
var server=http.createServer(function(req, res){
	if(req.url=='/list' && req.method=='GET'){
		var html='<html><head><meta charset="UTF-8"></head>';
		html+='<body><h1>Favorite</h1><ul>';
		for(var i=0;i<paints.length; i++){
			html+='<li><img src="http://127.0.0.1:3000/'+paints[i].image_url+'">'+paints[i].title+'</li>';
		}
		html+='</ul><hr/>';
		html+='<form method="post" action="/upload" enctype="multipart/form-data">';
		html+='작품이름:<input type="text" name="title"/>';
		html+='<br/><input type="file" name="file"/>';
		html+='<br/><input type="submit" value="upload"/>';
		html+='</form></body></html>';
		res.end(html);
	}else if(req.url=='/upload' && req.method=='POST'){
		//multipart/form-data로 넘어온 데이터를 읽어올 수 있도록 form객체로 생성한다.
		var form=formidable.IncomingForm();
		form.encoding="UTF-8";
		//확장자를 보존                                                                                           
		form.keepExtensions="true";
		//업로드시킬 경로 위치를 지정함
		form.uploadDir="./upload";
		
		//fields:요청 메세지 바디로 전달되는 값, 키
		//files: 요청 메세지 바디로 전달되는 파일,키
		//                      에러      파일외        파일
		form.parse(req,function(err, fields, files){
			var File=files.file;
			var filename=File['path']; //파일명 추출
			//역 슬래시를 슬래시로 변경
			filename.replace(/\\/gm,'/');
			//배열에 추가
			paints.push({title:fields.title, image_url:filename});
			//리스트페이지로 리다이렉트한다.
			res.statusCode=302;
			res.setHeader('Location','/list');
			res.end();
			
			console.log(filename);
		});
	}else{
		//img태그가 보여주는 부분을 요청하기 때문에 아래와 같은 구문을 넣어줘야지 이미지를 불러올 수 있다.
		var dirname=__dirname.substring(0,__dirname.lastIndexOf("\\"));
		var path=dirname+req.url;
		fs.exists(path,function(exist){
			if(exist){
				res.writeHead(200,{'Content-Type':'image/*'});
				fs.createReadStream(path).pipe(res);
			}else{
				res.status=404;
				res.end('Not Found');
			}
		})
	}
});//end server/////////////////////////////

//웹서버 실행
server.listen(3000, function(){
	console.log('server running at http://127.0.0.1:3000');
});