'use strict';

var HomeSearchResult = function() {

  var productTitleSelector = element.all(by.css('.scs-sitesearch-product-teaser-title')).first();
  var productTeaserSelector = element.all(by.css('.scs-sitesearch-product-teaser-intro')).first();

  this.getProductTitle = function() {
    return productTitleSelector.getText();
  };

  this.getProductTeaser = function() {
    return productTeaserSelector.getText();
  };

};
module.exports = HomeSearchResult;