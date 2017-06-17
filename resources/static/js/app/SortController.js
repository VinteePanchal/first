'use strict';

angular.module('sortApp').controller('SortController',
		[ 'SortService', '$scope', function(SortService, $scope) {

			var self = this;
			self.sortList = [];

			self.getData = getData;

			function getData() {
				return SortService.getAllList();
			}
		}

		]);