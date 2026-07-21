import React, { useState, useEffect, useRef } from "react";
import {
  Search,
  ArrowRight,
  User,
  Lightbulb,
  UserCheck,
  Users,
  CircleDollarSign,
  FileCheck,
  Handshake,
  Rocket,
} from "lucide-react";
import "./Home.css";
export default function Home() {
  const [isScrolled, setIsScrolled] = useState(false);
  const revealRefs = useRef([]);

  // Force body scrolling unlocked dynamically when component mounts
  useEffect(() => {
    document.documentElement.style.overflowY = "auto";
    document.body.style.overflowY = "auto";
    document.body.style.height = "auto";
    document.body.style.minHeight = "100vh";
    
    const rootEl = document.getElementById("root");
    if (rootEl) {
      rootEl.style.height = "auto";
      rootEl.style.minHeight = "100vh";
      rootEl.style.overflow = "visible";
    }
  }, []);

  // Navbar background switch on scroll
  useEffect(() => {
    const handleScroll = () => {
      if (window.scrollY > 40) {
        setIsScrolled(true);
      } else {
        setIsScrolled(false);
      }
    };

    window.addEventListener("scroll", handleScroll);
    return () => window.removeEventListener("scroll", handleScroll);
  }, []);

  // Intersection Observer for scroll animation triggers
  useEffect(() => {
    const observer = new IntersectionObserver(
      (entries) => {
        entries.forEach((entry) => {
          if (entry.isIntersecting) {
            const el = entry.target;
            const parent = el.parentElement;
            if (parent) {
              const siblingIndex = Array.from(parent.children).indexOf(el);
              el.style.animationDelay = `${siblingIndex * 0.1}s`;
            }
            el.classList.add("reveal");
            observer.unobserve(el);
          }
        });
      },
      { threshold: 0.05 } // Low threshold triggers visibility early on scroll
    );

    revealRefs.current.forEach((el) => {
      if (el) observer.observe(el);
    });

    return () => observer.disconnect();
  }, []);

  // Ripple effect on click
  const handleRipple = (e) => {
    const btn = e.currentTarget;
    const rect = btn.getBoundingClientRect();
    const ripple = document.createElement("span");
    const size = Math.max(rect.width, rect.height);

    ripple.className = "ripple-span";
    ripple.style.width = ripple.style.height = `${size}px`;
    ripple.style.left = `${e.clientX - rect.left - size / 2}px`;
    ripple.style.top = `${e.clientY - rect.top - size / 2}px`;

    btn.appendChild(ripple);
    setTimeout(() => ripple.remove(), 650);
  };

  const addToRefs = (el) => {
    if (el && !revealRefs.current.includes(el)) {
      revealRefs.current.push(el);
    }
  };

  return (
    <div className="portal-container">
      {/* ================= NAVBAR ================= */}
      <nav className={isScrolled ? "scrolled" : ""}>
        <div className="logo-area">
          <img
            src="../assests/Project_Logo_3.png"
            alt="Student Project Innovation Portal Logo"
          />
          <div className="logo-text">
            <h2>STUDENT PROJECT</h2>
            <h3>& INNOVATION PORTAL</h3>
          </div>
        </div>

        <ul className="nav-links">
          <li>
            <a href="#" className="active">
              Home
            </a>
          </li>
          <li>
            <a href="#features">Explore Projects</a>
          </li>
          <li>
            <a href="#features">Find Mentors</a>
          </li>
          <li>
            <a href="#how-it-works">Opportunities</a>
          </li>
          <li>
            <a href="#how-it-works">About Us</a>
          </li>
        </ul>

        <div className="nav-buttons">
          <button className="login-btn ripple-btn" onClick={handleRipple}>
            Login
          </button>
          <button className="register-btn ripple-btn" onClick={handleRipple}>
            Register
          </button>
        </div>
      </nav>

      {/* ================= HERO SECTION ================= */}
      <section className="hero">
        <div className="hero-content">
          <h1>
            Turn Your Ideas <br />
            Into Real <span>Innovation</span>
          </h1>
          <p>
            Discover project ideas, connect with mentors, build teams, collaborate
            on research, and bring your academic innovations to life.
          </p>

          <div className="search-box">
            <Search className="search-icon" size={20} />
            <input
              type="text"
              placeholder="Search project ideas, technologies, mentors..."
            />
            <button>Search</button>
          </div>

          <div className="hero-buttons">
            <button className="explore-btn ripple-btn" onClick={handleRipple}>
              Explore Projects <ArrowRight size={18} className="btn-icon" />
            </button>
            <button className="mentor-btn ripple-btn" onClick={handleRipple}>
              Find a Mentor <User size={18} className="btn-icon" />
            </button>
          </div>
        </div>

        {/* RIGHT SIDE LOGO */}
        <div className="hero-logo">
          <img
            src="Project_Logo_3.png"
            alt="Student Project and Innovation Portal"
          />
          <h2>STUDENT PROJECT</h2>
          <h3>& INNOVATION PORTAL</h3>
        </div>
      </section>

      {/* ================= FEATURE CARDS ================= */}
      <section className="features-wrapper" id="features">
        <div className="feature-container">
          <div className="feature-card" ref={addToRefs}>
            <div className="feature-icon">
              <Lightbulb size={28} />
            </div>
            <div>
              <h3>Project Ideas</h3>
              <p>
                Find beginner-friendly and advanced project ideas across various
                domains.
              </p>
            </div>
          </div>

          <div className="feature-card" ref={addToRefs}>
            <div className="feature-icon">
              <UserCheck size={28} />
            </div>
            <div>
              <h3>Find Mentors</h3>
              <p>
                Connect with experienced mentors, developers, researchers, and
                professionals.
              </p>
            </div>
          </div>

          <div className="feature-card" ref={addToRefs}>
            <div className="feature-icon">
              <Users size={28} />
            </div>
            <div>
              <h3>Build Teams</h3>
              <p>
                Find students with different skills and collaborate on innovative
                projects.
              </p>
            </div>
          </div>

          <div className="feature-card" ref={addToRefs}>
            <div className="feature-icon">
              <CircleDollarSign size={28} />
            </div>
            <div>
              <h3>Opportunities</h3>
              <p>
                Find internships, research opportunities, stipends, scholarships,
                and funding.
              </p>
            </div>
          </div>
        </div>
      </section>

      {/* ================= HOW IT WORKS ================= */}
      <section className="how-section" id="how-it-works">
        <h2 className="section-title" ref={addToRefs}>
          How It Works
        </h2>

        <div className="steps">
          <div className="step" ref={addToRefs}>
            <div className="step-number">1</div>
            <h3>Discover</h3>
            <p>
              Explore project ideas based on your interests and technical
              skills.
            </p>
            <FileCheck className="step-icon" size={30} />
          </div>

          <div className="step" ref={addToRefs}>
            <div className="step-number">2</div>
            <h3>Connect</h3>
            <p>Connect with mentors, students, and researchers.</p>
            <Users className="step-icon" size={30} />
          </div>

          <div className="step" ref={addToRefs}>
            <div className="step-number">3</div>
            <h3>Collaborate</h3>
            <p>Build teams and work together on your project.</p>
            <Handshake className="step-icon" size={30} />
          </div>

          <div className="step" ref={addToRefs}>
            <div className="step-number">4</div>
            <h3>Innovate</h3>
            <p>Create, publish, and showcase your innovation.</p>
            <Rocket className="step-icon" size={30} />
          </div>
        </div>
      </section>
    </div>
  );
}