export class HomeSearchResult {

	private productTitleElement;
    private productTeaserElement;

    constructor() {
        this.productTitleElement = element.all(by.css('.scs-sitesearch-product-teaser-title')).first();
        this.productTeaserElement = element.all(by.css('.scs-sitesearch-product-teaser-intro')).first();
    }


    get productTitle() {
        return this.productTitleElement;
    }

    get productTeaser() {
        return this.productTeaserElement;
    }
}

