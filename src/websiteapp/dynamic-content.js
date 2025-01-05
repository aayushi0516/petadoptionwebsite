document.addEventListener('DOMContentLoaded', () => {
    const contentDiv = document.getElementById('content');
    const homeLink = document.getElementById('home-link');
    const availablePetsLink = document.getElementById('available-pets-link');

    // Load the default home content
    const loadHomeContent = () => {
        contentDiv.innerHTML = `
            <div class="text-center">
                <h2 class="text-3xl font-bold">Welcome to Paws & Hearts</h2>
                <p class="text-lg mt-4">Your one-stop solution to finding and adopting your perfect pet companion.</p>
            </div>`;
    };

    // Load content from external files
    const loadContent = async (url) => {
        try {
            const response = await fetch(url);
            const html = await response.text();
            contentDiv.innerHTML = html;
        } catch (error) {
            console.error('Error loading content:', error);
            contentDiv.innerHTML = '<p class="text-red-500">Failed to load content. Please try again.</p>';
        }
    };

    // Add event listeners for navigation links
    homeLink.addEventListener('click', (event) => {
        event.preventDefault();
        loadHomeContent(); // Load home content dynamically
    });

    availablePetsLink.addEventListener('click', (event) => {
        event.preventDefault();
        loadContent('search.html');
    });

    // Load home content by default on page load
    loadHomeContent();
});
