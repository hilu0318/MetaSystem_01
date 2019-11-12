/**
 * 
 */
class DataUtil{
	constructor(){
		this.setDataToGrid;
	}
}

DataUtil.setDataToGrid = function(tableId, dataList){
	var nConLst = new Array();
	var table01 = document.getElementById(tableId);
	var thead = table01.getElementsByTagName("thead")[0];
	var tbody = table01.getElementsByTagName("tbody")[0];
	var trTag;
	var tdTag;
	var nThLst = thead.getElementsByTagName("th");
	for(var i = 0; i < nThLst.length; i++){
		nConLst.push(nThLst[i].getAttribute("id"));
		//printLog("th[" + i + "] id = '" + nThLst[i].getAttribute("id") + "'");
	}
    //printLog(nConLst.length);
	for(var i = 0; i < dataList.length; i++){
		trTag = document.createElement("tr");
		trTag.setAttribute("id", i);
		for(var j = 0; j < nConLst.length; j++){
			tdTag = document.createElement("td");
			tdTag.setAttribute("id", nConLst[j])
			tdTag.innerHTML = dataList[i][nConLst[j]] === undefined ? "" : dataList[i][nConLst[j]];
			trTag.appendChild(tdTag);
		}
		tbody.appendChild(trTag);
	}
}