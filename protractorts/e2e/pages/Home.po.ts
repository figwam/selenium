export class Home {

	private searchOpenElement;
    private searchFieldElement;
    private searchButtonElement;

    constructor() {
        this.searchOpenElement = element(by.css('.scsh-sitesearch-open-button'));
        this.searchFieldElement = element(by.id('scs-sitesearch-search-field-2050931542'));
        this.searchButtonElement = element(by.id('scsh-sitesearch-button-2050931542'));
    }

    open(): void {
        browser.get('http://www.swisscom.ch');
    }

    doSearch(name: string): void {
    	this.searchOpenElement.click();
		this.searchFieldElement.clear();
		this.searchFieldElement.sendKeys(name);
		this.searchButtonElement.submit();
    }

}
