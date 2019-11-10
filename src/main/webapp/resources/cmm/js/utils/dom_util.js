/**
 * 
 */
class DomUtil{
	constructor(){
		this.setValueForElemntByName;
		this.setValueForElemntById;
	}
}

DomUtil.setValueForElemntByName = function(name, value){
	var nNodeLst = document.getElementsByName(name);
	if(nNodeLst.length == 0){
		throw new Error("잘못된 이름입니다. 확인 바랍니다.");
	}
	nNodeLst[0].setAttribute("value", value);
}

DomUtil.setValueForElemntById = function(id, value){
	var nElemnt = document.getElementById(id);
	if(typeof nElemnt == "undefined" || nElemnt == null){
		throw new Error("잘못된 ID입니다. 확인 바랍니다.");
	}
	nElemnt.setAttribute("value", value);
}
