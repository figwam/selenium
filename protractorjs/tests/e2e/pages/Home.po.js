'use strict';

var Home = function() {

  var searchButtonSelector = element(by.css('.scsh-sitesearch-open-button'));
  var searchFieldSelector = element(by.id('scs-sitesearch-search-field-2050931542'));
  var searchFieldButtonSelector = element(by.id('scsh-sitesearch-button-2050931542'));

  this.open = function() {
    browser.get('http://www.swisscom.ch'); //overrides baseURL  
  };

  this.doSearch = function(name) {
    searchButtonSelector.click();
    searchFieldSelector.clear();
    searchFieldSelector.sendKeys(name);
    searchFieldButtonSelector.submit();
  };
};

module.exports = Home;