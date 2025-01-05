// search.js

document.addEventListener('DOMContentLoaded', () => {
    // Select the search button
    const searchButton = document.getElementById('search-button');

    // Add click event listener to redirect to petcards.html
    searchButton.addEventListener('click', () => {
        // Capture filter selections if needed
        const animalType = document.querySelector('select:nth-child(1)').value; // Animal type
        const ageGroup = document.querySelector('select:nth-child(2)').value; // Age group
        const size = document.querySelector('select:nth-child(3)').value; // Size

        // Build query parameters to pass to the next page (if needed)
        const queryParams = new URLSearchParams({
            type: animalType,
            age: ageGroup,
            size: size,
        });

        searchButton.addEventListener('click', (event) => {
            event.preventDefault();
            loadContent('petcards.html');
        });
    


        // Redirect to petcards.html with query parameters
        window.location.href = `petcards.html?${queryParams.toString()}`;
    });
});
