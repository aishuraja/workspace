package raja.cs665.hw3;

public abstract class BankUI {
    public final void createUI(){
        createHeader();
        createSidebar();
        createMainPanel();
        createFooter();
        System.out.println("\nUser interface completed as below :");
        getUI();
    }

    // These methods will be implemented by concrete classes
    protected abstract void createHeader();
    protected abstract void createSidebar();
    protected abstract void createMainPanel();
    protected abstract void createFooter();

    // This method is implemented in the base class
    protected void getUI() {
        System.out.println("Step 1: " + getHeaderDescription());
        System.out.println("Step 2: " + getSidebarDescription());
        System.out.println("Step 3: " + getMainPanelDescription());
        System.out.println("Step 4: " + getFooterDescription());
    }

    // These methods will be implemented by concrete classes
    protected abstract String getHeaderDescription();
    protected abstract String getSidebarDescription();
    protected abstract String getMainPanelDescription();
    protected abstract String getFooterDescription();
}
