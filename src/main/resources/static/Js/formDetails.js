var app=angular.module('MyApp',['ngRoute']);

app.controller('mycontrol',function($scope,$http){
	var names;
	var val;
	$scope.loader=function(){
		 $http({
    method : "GET",
    url : "/getall"
	 }).then(function mySuccess(response) {
	$scope.names=response.data;
	}, function myError(response) {
     
	 alert("error fetching data");
  });
 
  
};
$scope.ch="entered";
	$scope.GetValue = function (names) {
	
                var nameId = $scope.capture;
      
	   $http({
    method : "GET",
    url : "/getdetails?Id="+nameId
	 }).then(function mySuccess(response) {
		 $scope.val=response.data;
		$scope.check1="bye";
	 
    }, function myError(response) {
      $scope.check="hai";
	 alert("nothing");
  });
		

       
	
};
                
	
	
	});
	
app.config(['$routeProvider', function($routeProvider){
   $routeProvider.
    when('/form', {
	  
      templateUrl: 'form.html',
	  controller: 'addreceipe'
   }).
   
   when('/details', {
      templateUrl: 'details.html',
	  controller: 'mycontrol'
   }).
   otherwise({
        templateUrl: 'welcome.html'
      });
	  }]);


app.controller('addreceipe',function($scope,$http){
	
	$scope.mustBeFilled = function () {
  if($scope.Ingredient1.length || $scope.Ingredient2.length|| $scope.Ingredient3.length|| $scope.Ingredient4.length){
    return false
  } else {
    return true
  }
};

	$scope.submitfunc = function () {
		

        $http.get("/include?name="+$scope.firstname+"&recipe1="+$scope.Ingredient1+"&receipe2="+$scope.Ingredient2+"&receipe3="+$scope.Ingredient3+"&receipe4="+$scope.Ingredient4+"")
.success(function (data, status, headers, config) {
               $scope.message="Record Added Successfully";
            }).
            error(function (data, status, headers, config) {
              $scope.message="Failed to Add";
            });
	
};



});


		
		



	