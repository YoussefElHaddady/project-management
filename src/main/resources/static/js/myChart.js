var chartDataStr = decodeHtml(chartData);
var chartJsonArr = JSON.parse(chartDataStr);

var arrLen = chartJsonArr.length;
var numericData = [];
var labelData = [];

for(var i=0; i<arrLen; i++) {
	numericData[i] = chartJsonArr[i].value;
	labelData[i] = chartJsonArr[i].label;
}

new Chart(document.getElementById("myPieChart"), {
	type: 'pie',
	data: {
		labels: labelData,
		datasets: [{
			label: "Projects Statuses dataset",
			backgroundColor: ["#28a745", "#007bff", "#dc3545"],
			borderColor: "rgb(255, 99, 132)",
			borderWidth: "1px",
			data: numericData,
		}]
	},
	options: {
		title: {
			display: true,
			test: 'Project Statuses'
		}
	}
	
});

function decodeHtml(html) {
	var txt = document.createElement("textarea");
	txt.innerHTML = html;
	return txt.value;
}