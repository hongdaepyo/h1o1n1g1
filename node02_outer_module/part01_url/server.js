/**
 * http://usejsdoc.org/
 */

//url모듈을 추출한다.(import한다)
var url=require('url');

var urlStr="http://idols.com/q?group=EXIT&name=kim"
	/*urlStr:Url정보
	true:파라미터 사용여부(true은 사용, false은 불사용)
	url.parse:urlStr문자열을 Object로 변경*/
var parsed=url.parse(urlStr,true);
console.log(parsed);
console.log("===============================")
console.log("protocol=>"+parsed.protocol);
console.log("query.group=>"+parsed.query.group);
console.log("query.name=>"+parsed.query.name);
var querystring=require('querystring');
var queryParsed=querystring.parse(parsed.query);
console.log(queryParsed); //{ }

//{ '?group': 'EXIT', name: 'kim' }
var queryParsed2=querystring.parse(parsed.search);

console.log(queryParsed2);
