// scripts.js

// Function to handle navigation
function navigateTo(page) {
    if (page === 'home') {
        window.location.href = 'index.html'; // Go to front-page.html
    } else if (page === 'about') {
        window.location.href = 'about-us.html'; // Go to about-us.html
    }
}

// Add event listeners to the navigation links dynamically
document.addEventListener('DOMContentLoaded', () => {
    // Home link
    const homeLink = document.getElementById('home-link');
    if (homeLink) {
        homeLink.addEventListener('click', () => navigateTo('home'));
    }

    // About link
    const aboutLink = document.getElementById('about-link');
    if (aboutLink) {
        aboutLink.addEventListener('click', () => navigateTo('about'));
    }
});
